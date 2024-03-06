package com.enova.enovasantebackend.service;

import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.dto.DTOCategorieDocumentRequest;
import com.enova.enovasantebackend.dto.DTOCategorieDocumentResponse;
import com.enova.enovasantebackend.exception.CategorieDocumentNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CategorieDocumentService {
    // Get all entities 'CategorieDocument'
    List<DTOCategorieDocumentResponse> getAll();

    // Get page
    Page<DTOCategorieDocumentResponse> getPage(Pageable page);

    // Get entity 'CategorieDocument' by id
    DTOCategorieDocumentResponse getById(String id) throws CategorieDocumentNotFoundException;

    // Save a new entity 'CategorieDocument'
    DTOCategorieDocumentResponse save(DTOCategorieDocumentRequest request);

    // Update an existing entity 'CategorieDocument'
    DTOCategorieDocumentResponse update(DTOCategorieDocumentRequest request, String id);

    // Remove an entity 'CategorieDocument'
    void delete(String id);

    // Filter by 'code' value
    List<DTOCategorieDocumentResponse> getByCode(String code);

    List<CategorieDocument> getBySpecification(Specification<CategorieDocument> specification);
}
