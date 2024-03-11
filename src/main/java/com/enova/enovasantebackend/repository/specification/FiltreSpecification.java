package com.enova.enovasantebackend.repository.specification;


import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.enums.GlobalOperator;
import com.enova.enovasantebackend.repository.criteria.SearchCriteriaDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FiltreSpecification<T> {

    public Specification<T> getSearchSpecification(SearchCriteriaDTO searchCriteriaDTO) {
        Specification<T> specification=new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(searchCriteriaDTO.getColonne()), searchCriteriaDTO.getValue());
            }};
        return specification;
    }

    public Specification<T> getSearchSpecification(List<SearchCriteriaDTO> searchCriteriaDTO, GlobalOperator globalOperator) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates=new ArrayList<>();

            for(SearchCriteriaDTO search:searchCriteriaDTO){
                switch (search.getOperator()){
                    case EQUAL :
                        Predicate equal=criteriaBuilder.equal(root.get(search.getColonne()), search.getValue());
                        predicates.add(equal);
                        break;
                    case LIKE:
                        Predicate like=criteriaBuilder.like(root.get(search.getColonne()),"%"+search.getValue()+"%");
                        predicates.add(like);
                        break;
                    case IN :
                        String[] split = search.getValue().split( ",");
                        Predicate in = root.get(search.getColonne()).in(Arrays.asList(split));
                        predicates.add(in);
                        break;
                    case LESS_THAN:
                        Predicate less_than=criteriaBuilder.lessThan(root.get(search.getColonne()),search.getValue());
                        predicates.add(less_than);
                        break;
                    case GREATER_THAN:
                        Predicate greaterThan=criteriaBuilder.greaterThan(root.get(search.getColonne()),search.getValue());
                        predicates.add(greaterThan);
                        break;
                    case BETWEEN:
                        String[] separer = search.getValue().split( ",");
                        Predicate between=criteriaBuilder.between(root.get(search.getColonne()),separer[0],separer[1]);
                        predicates.add(between);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value");
                 }

            }


            if (globalOperator.equals(GlobalOperator.AND)) {
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
            else{
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            }
        };
    }

}
