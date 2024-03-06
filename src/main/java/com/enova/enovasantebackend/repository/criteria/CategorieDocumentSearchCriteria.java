package com.enova.enovasantebackend.repository.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class CategorieDocumentSearchCriteria {
    private String column;
    private String value;
}
