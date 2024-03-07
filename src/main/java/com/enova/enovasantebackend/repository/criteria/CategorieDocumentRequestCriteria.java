package com.enova.enovasantebackend.repository.criteria;

import lombok.Data;

import java.util.List;

@Data
public class CategorieDocumentRequestCriteria {
    private PageRequestCriteria pageRequestCriteria = new PageRequestCriteria();
    private List<CategorieDocumentSearchCriteria> searchCriteriaList;
}
