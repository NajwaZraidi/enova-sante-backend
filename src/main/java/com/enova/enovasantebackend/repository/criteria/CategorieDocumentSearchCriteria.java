package com.enova.enovasantebackend.repository.criteria;

import com.enova.enovasantebackend.enums.CriteriaSearchOperator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class CategorieDocumentSearchCriteria {
    private String column;
    private String value;
    @Builder.Default
    private CriteriaSearchOperator searchOperator = CriteriaSearchOperator.EQUAL;
}
