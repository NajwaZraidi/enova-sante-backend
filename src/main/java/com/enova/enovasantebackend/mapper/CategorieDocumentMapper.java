package com.enova.enovasantebackend.mapper;

import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.dto.CategorieDocumentRequestDTO;
import com.enova.enovasantebackend.dto.CategorieDocumentResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CategorieDocumentMapper {
    public CategorieDocumentResponseDTO toResponse(CategorieDocument entity) {
        CategorieDocumentResponseDTO target = new CategorieDocumentResponseDTO();
        BeanUtils.copyProperties(entity, target);
        return target;
    }

    public CategorieDocument toEntity(CategorieDocumentRequestDTO request) {
        CategorieDocument target = new CategorieDocument();
        BeanUtils.copyProperties(request, target);
        return target;
    }
}
