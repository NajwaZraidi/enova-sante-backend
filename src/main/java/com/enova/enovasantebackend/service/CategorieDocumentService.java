package com.enova.enovasantebackend.service;

import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.dto.DTOCategorieDocumentRequest;
import com.enova.enovasantebackend.dto.DTOCategorieDocumentResponse;
import com.enova.enovasantebackend.exception.CategorieDocumentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategorieDocumentService {
    // Get all entities 'CategorieDocument'
    List<DTOCategorieDocumentResponse> getAll();

    // Get entity 'CategorieDocument' by id
    DTOCategorieDocumentResponse getById(String id) throws CategorieDocumentNotFoundException;

    // Save a new entity 'CategorieDocument'
    DTOCategorieDocumentResponse save(DTOCategorieDocumentRequest request);

    // Update an existing entity 'CategorieDocument'
    DTOCategorieDocumentResponse update(DTOCategorieDocumentRequest request, String id);

    // Remove an entity 'CategorieDocument'
    void delete(String id);
}
