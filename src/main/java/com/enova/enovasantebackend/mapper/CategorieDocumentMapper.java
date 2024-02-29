package com.enova.enovasantebackend.mapper;

import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.dto.DTOCategorieDocumentRequest;
import com.enova.enovasantebackend.dto.DTOCategorieDocumentResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CategorieDocumentMapper {
    public DTOCategorieDocumentResponse toResponse(CategorieDocument entity) {
        DTOCategorieDocumentResponse target = new DTOCategorieDocumentResponse();
        BeanUtils.copyProperties(entity, target);
        return target;
    }

    public CategorieDocument toEntity(DTOCategorieDocumentRequest request) {
        CategorieDocument target = new CategorieDocument();
        BeanUtils.copyProperties(request, target);
        return target;
    }
}
