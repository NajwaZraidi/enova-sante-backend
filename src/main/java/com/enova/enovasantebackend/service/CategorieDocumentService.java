package com.enova.enovasantebackend.service;

import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.dto.CategorieDocumentRequestDTO;
import com.enova.enovasantebackend.dto.CategorieDocumentResponseDTO;
import com.enova.enovasantebackend.exception.CategorieDocumentNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CategorieDocumentService {
    // Get all entities 'CategorieDocument'
    List<CategorieDocumentResponseDTO> getAll();

    // Get page
    Page<CategorieDocumentResponseDTO> getPage(Pageable page);

    // Get entity 'CategorieDocument' by id
    CategorieDocumentResponseDTO getById(String id) throws CategorieDocumentNotFoundException;

    // Save a new entity 'CategorieDocument'
    CategorieDocumentResponseDTO save(CategorieDocumentRequestDTO request);

    // Update an existing entity 'CategorieDocument'
    CategorieDocumentResponseDTO update(CategorieDocumentRequestDTO request, String id);

    // Remove an entity 'CategorieDocument'
    void delete(String id);

    // Filter by 'code' value
    List<CategorieDocumentResponseDTO> getByCode(String code);

    Page<CategorieDocument> getBySpecification(Specification<CategorieDocument> specification, Pageable pageable);
}
