package com.enova.enovasantebackend.repository.specification;

import com.enova.enovasantebackend.enums.CriteriaConcatOperator;
import com.enova.enovasantebackend.repository.criteria.CategorieDocumentSearchCriteria;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FilterSpecificationService<T> {

    // This method will get a list of search criterias and the concat operation and creates a specification
    public Specification<T> getSearchSpecification(List<CategorieDocumentSearchCriteria> searchCriteriaList, CriteriaConcatOperator concatOperator) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            for (CategorieDocumentSearchCriteria searchRequest : searchCriteriaList) {
                switch (searchRequest.getSearchOperator()) {
                    case EQUAL -> {
                        Predicate equal = criteriaBuilder.equal(root.get(searchRequest.getColumn()), searchRequest.getValue());
                        predicates.add(equal);
                    }
                    case LIKE -> {
                        Predicate like = criteriaBuilder.like(root.get(searchRequest.getColumn()), "%" + searchRequest.getValue() + "%");
                        predicates.add(like);
                    }
                    case IN -> {
                        String[] split = searchRequest.getValue().split(",");
                        Predicate in = root.get(searchRequest.getColumn()).in(Arrays.asList(split));
                        predicates.add(in);
                    }
                    case GREATER_THAN -> {
                        Predicate greaterThan = criteriaBuilder.greaterThan(root.get(searchRequest.getColumn()), searchRequest.getValue());
                        predicates.add(greaterThan);
                    }
                    case LESS_THAN -> {
                        Predicate lessThan = criteriaBuilder.lessThan(root.get(searchRequest.getColumn()), searchRequest.getValue());
                        predicates.add(lessThan);
                    }
                    case BETWEEN -> {
                        String[] borders = searchRequest.getValue().split(",");
                        Predicate between = criteriaBuilder.between(root.get(searchRequest.getColumn()), borders[0], borders[1]);
                        predicates.add(between);
                    }
                    default -> throw new IllegalStateException("Unexpected value of " + searchRequest.getSearchOperator());
                }
            }
            if(concatOperator.equals(CriteriaConcatOperator.OR))
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}