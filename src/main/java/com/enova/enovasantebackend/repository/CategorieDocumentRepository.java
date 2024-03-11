package com.enova.enovasantebackend.repository;

import com.enova.enovasantebackend.domain.CategorieDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategorieDocumentRepository extends JpaRepository<CategorieDocument, String>, JpaSpecificationExecutor<CategorieDocument> {
    Page<CategorieDocument> findAll(Pageable pageable);

    //Query method
     CategorieDocument findByCode(String code);
}
