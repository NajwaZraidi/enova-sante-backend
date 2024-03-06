package com.enova.enovasantebackend.repository.specification;

import com.enova.enovasantebackend.repository.criteria.CategorieDocumentSearchCriteria;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterSpecificationService<T> {

    // This method will get a search criteria and creates a specification for it
    public Specification<T> getSearchSpecification(CategorieDocumentSearchCriteria searchCriteria) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(searchCriteria.getColumn()), searchCriteria.getValue());
    }

    // This method will get a list of search criterias and creates a specification for them
    public Specification<T> getSearchSpecification(List<CategorieDocumentSearchCriteria> searchCriteriaList) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            for (CategorieDocumentSearchCriteria searchRequest : searchCriteriaList) {
                Predicate equal = criteriaBuilder.equal(root.get(searchRequest.getColumn()), searchRequest.getValue());
                predicates.add(equal);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
