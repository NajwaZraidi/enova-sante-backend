package com.enova.enovasantebackend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Builder
@Data @AllArgsConstructor @NoArgsConstructor
public class CategorieDocument {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String code;
    private String libelle;
    private String description;
    private Integer ordre;
    private Boolean actif;
    private String hl7;
}
