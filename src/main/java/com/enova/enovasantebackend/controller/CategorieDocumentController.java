package com.enova.enovasantebackend.controller;

import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.dto.DTOCategorieDocumentRequest;
import com.enova.enovasantebackend.dto.DTOCategorieDocumentResponse;
import com.enova.enovasantebackend.exception.CategorieDocumentNotFoundException;
import com.enova.enovasantebackend.repository.criteria.CategorieDocumentSearchCriteria;
import com.enova.enovasantebackend.repository.specification.FilterSpecificationService;
import com.enova.enovasantebackend.service.CategorieDocumentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorie-document")
@AllArgsConstructor
@CrossOrigin("*")
public class CategorieDocumentController {
    CategorieDocumentService categorieDocumentService;
    FilterSpecificationService<CategorieDocument> filterSpecificationService;

    // Get all entities 'CategorieDocument'
    @GetMapping("all")
    public ResponseEntity<List<DTOCategorieDocumentResponse>> getAll() {
        return ResponseEntity.ok(categorieDocumentService.getAll());
    }

    // Get all entities 'CategorieDocument' by page size
    @GetMapping("getPage")
    public ResponseEntity<Page<DTOCategorieDocumentResponse>> getPage(@RequestBody com.enova.enovasantebackend.utils.Page page) {
        System.out.println("Getting results as page page ...");
        System.out.println(page);
        return ResponseEntity.ok(categorieDocumentService.getPage(PageRequest.of(page.getPage(), page.getSize())));
    }

    // Get entity 'CategorieDocument' by id
    @GetMapping("by-id/{id}")
    public ResponseEntity<DTOCategorieDocumentResponse> getById(@PathVariable String id) throws CategorieDocumentNotFoundException {
        return ResponseEntity.ok(categorieDocumentService.getById(id));
    }

    // Get by specification
    @PostMapping("specification")
    public ResponseEntity<List<CategorieDocument>> getBySpecification(@RequestBody CategorieDocumentSearchCriteria criteria) {
        List<CategorieDocument> result = categorieDocumentService.getBySpecification(filterSpecificationService.getSearchSpecification(criteria));
        return ResponseEntity.ok(result);
    }

    // Get by specifications
    @PostMapping("specifications")
    public ResponseEntity<List<CategorieDocument>> getBySpecifications(@RequestBody List<CategorieDocumentSearchCriteria> criteriaList) {
        List<CategorieDocument> result = categorieDocumentService.getBySpecification(filterSpecificationService.getSearchSpecification(criteriaList));
        return ResponseEntity.ok(result);
    }

    // Save a new entity 'CategorieDocument'
    @PostMapping("save")
    public ResponseEntity<DTOCategorieDocumentResponse> save(@RequestBody DTOCategorieDocumentRequest request) {
        return ResponseEntity.ok(categorieDocumentService.save(request));
    }

    // Update an existing entity 'CategorieDocument'
    @PutMapping("update/{id}")
    public ResponseEntity<DTOCategorieDocumentResponse> update(@RequestBody DTOCategorieDocumentRequest request, @PathVariable String id) {
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
    public ResponseEntity<List<DTOCategorieDocumentResponse>> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(categorieDocumentService.getByCode(code));
    }
}
