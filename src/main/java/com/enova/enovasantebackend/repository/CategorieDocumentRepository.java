package com.enova.enovasantebackend.repository;

import com.enova.enovasantebackend.domain.CategorieDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;

public interface CategorieDocumentRepository extends JpaRepository<CategorieDocument, String>, JpaSpecificationExecutor<CategorieDocument> {
    List<CategorieDocument> findCategorieDocumentsByCode(String code);
    
    CategorieDocument findByCode(String code);
}
