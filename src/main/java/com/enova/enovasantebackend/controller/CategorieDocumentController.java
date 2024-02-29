package com.enova.enovasantebackend.controller;

import com.enova.enovasantebackend.dto.DTOCategorieDocumentRequest;
import com.enova.enovasantebackend.dto.DTOCategorieDocumentResponse;
import com.enova.enovasantebackend.exception.CategorieDocumentNotFoundException;
import com.enova.enovasantebackend.service.CategorieDocumentService;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<List<DTOCategorieDocumentResponse>> getAll() {
        return ResponseEntity.ok(categorieDocumentService.getAll());
    }

    // Get entity 'CategorieDocument' by id
    @GetMapping("by-id/{id}")
    public ResponseEntity<DTOCategorieDocumentResponse> getById(@PathVariable String id) throws CategorieDocumentNotFoundException {
        return ResponseEntity.ok(categorieDocumentService.getById(id));
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
}
