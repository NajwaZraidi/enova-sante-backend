package com.enova.enovasantebackend.service;

import com.enova.enovasantebackend.domain.CategorieDocument;

import com.enova.enovasantebackend.enums.GlobalOperator;
import com.enova.enovasantebackend.repository.criteria.PageRequestDTO;
import com.enova.enovasantebackend.repository.criteria.SearchCriteriaDTO;

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

    Page<CategorieDocumentResponseDTO> getAllDocumentCategorie(PageRequestDTO pageRequestDTO);

    //Query Model
    CategorieDocumentResponseDTO getCategorieByCode(String code);

    //specifications && pagination
    Page<CategorieDocumentResponseDTO> getCategoriesByCriteria(List<SearchCriteriaDTO> searchCriteriaDTO, GlobalOperator operator,PageRequestDTO requestDTO);



}
