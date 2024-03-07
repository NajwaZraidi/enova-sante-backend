package com.enova.enovasantebackend.controller;

import com.enova.enovasantebackend.dto.CategorieDocumentRequestDTO;
import com.enova.enovasantebackend.dto.CategorieDocumentResponseDTO;
import com.enova.enovasantebackend.enums.GlobalOperator;
import com.enova.enovasantebackend.repository.criteria.CriteriaDTO;
import com.enova.enovasantebackend.repository.criteria.SearchCriteriaDTO;
import com.enova.enovasantebackend.exception.CategorieDocumentNotFoundException;
import com.enova.enovasantebackend.repository.CategorieDocumentRepository;
import com.enova.enovasantebackend.service.CategorieDocumentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
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

    // Get all entities 'CategorieDocument'
    @GetMapping("all")
    public ResponseEntity<List<CategorieDocumentResponseDTO>> getAll() {
        return ResponseEntity.ok(categorieDocumentService.getAll());
    }

    @PostMapping("all")
    public ResponseEntity<Page<CategorieDocumentResponseDTO>> getAllD(@RequestParam(name="page",defaultValue = "0")  int page, @RequestParam(name="size",defaultValue = "5") int size) {
        return ResponseEntity.ok(categorieDocumentService.getAllDocumentCategorie(page,size));
    }

    // Get entity 'CategorieDocument' by id
    @GetMapping("by-id/{id}")
    public ResponseEntity<CategorieDocumentResponseDTO> getById(@PathVariable String id) throws CategorieDocumentNotFoundException {
        return ResponseEntity.ok(categorieDocumentService.getById(id));
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

    @GetMapping("by-code/{code}")
    public ResponseEntity<CategorieDocumentResponseDTO> getCategorieByCode(@PathVariable String code) throws CategorieDocumentNotFoundException {
        return ResponseEntity.ok(categorieDocumentService.getCategorieByCode(code));
    }

    CategorieDocumentRepository repository;
    @PostMapping("specifications")
    public ResponseEntity<List<CategorieDocumentResponseDTO>> getCategories(@RequestBody CriteriaDTO criteriaDTO){
        return ResponseEntity.ok(categorieDocumentService.getCategoriesByCriteria(criteriaDTO.getSearchCriteriaDTO(),criteriaDTO.getGlobalOperator()));
    }
}
