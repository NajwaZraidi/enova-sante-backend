package com.enova.enovasantebackend.controller;

import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.dto.CategorieDocumentRequestDTO;
import com.enova.enovasantebackend.dto.CategorieDocumentResponseDTO;
import com.enova.enovasantebackend.repository.criteria.PageRequestCriteria;
import com.enova.enovasantebackend.repository.criteria.CategorieDocumentRequestCriteria;
import com.enova.enovasantebackend.enums.CriteriaConcatOperator;
import com.enova.enovasantebackend.exception.CategorieDocumentNotFoundException;
import com.enova.enovasantebackend.repository.specification.FilterSpecificationService;
import com.enova.enovasantebackend.service.CategorieDocumentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/categorie-document")
@AllArgsConstructor
@CrossOrigin("*")
public class CategorieDocumentController {
    CategorieDocumentService categorieDocumentService;
    FilterSpecificationService<CategorieDocument> filterSpecificationService;

    // Get all entities 'CategorieDocument'
    @GetMapping("all")
    public ResponseEntity<List<CategorieDocumentResponseDTO>> getAll() {
        return ResponseEntity.ok(categorieDocumentService.getAll());
    }

    // Get all entities 'CategorieDocument' by page
    @GetMapping("getPage")
    public ResponseEntity<Page<CategorieDocumentResponseDTO>> getPage(@RequestBody(required = false) PageRequestCriteria pageRequestCriteria) {
        PageRequestCriteria request = Objects.nonNull(pageRequestCriteria) ? pageRequestCriteria : new PageRequestCriteria();
        return ResponseEntity.ok(categorieDocumentService.getPage(request.getPageable()));
    }

    // Get entity 'CategorieDocument' by id
    @GetMapping("by-id/{id}")
    public ResponseEntity<CategorieDocumentResponseDTO> getById(@PathVariable String id) throws CategorieDocumentNotFoundException {
        return ResponseEntity.ok(categorieDocumentService.getById(id));
    }

    // Get by specifications
    @PostMapping("specifications")
    public ResponseEntity<Page<CategorieDocument>> getBySpecifications(
            @RequestBody CategorieDocumentRequestCriteria requestCriteria,
            @RequestParam(defaultValue = "AND") String concatOperator
    ) {
        CriteriaConcatOperator criteriaConcatOperator = CriteriaConcatOperator.valueOf(concatOperator.toUpperCase());
        Specification<CategorieDocument> searchSpecification = filterSpecificationService.getSearchSpecification(requestCriteria.getSearchCriteriaList(), criteriaConcatOperator);
        Page<CategorieDocument> result = categorieDocumentService.getBySpecification(searchSpecification, requestCriteria.getPageRequestCriteria().getPageable());
        return ResponseEntity.ok(result);
    }

    // Save a new entity 'CategorieDocument'
    @PostMapping("save")
    public ResponseEntity<CategorieDocumentResponseDTO> save(@RequestBody CategorieDocumentRequestDTO request) {
        return ResponseEntity.ok(categorieDocumentService.save(request));
    }

    // Update an existing entity 'CategorieDocument'
    @PutMapping("update/{id}")
    public ResponseEntity<CategorieDocumentResponseDTO> update(@RequestBody CategorieDocumentRequestDTO request, @PathVariable String id) {
        return ResponseEntity.ok(categorieDocumentService.update(request, id));
    }

    // Remove an entity 'CategorieDocument'
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        categorieDocumentService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Find by code
    @GetMapping("by-code/{code}")
    public ResponseEntity<List<CategorieDocumentResponseDTO>> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(categorieDocumentService.getByCode(code));
    }
}
