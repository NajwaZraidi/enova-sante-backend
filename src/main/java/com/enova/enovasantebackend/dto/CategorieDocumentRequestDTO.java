package com.enova.enovasantebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorieDocumentRequestDTO {
    private String code;
    private String libelle;
    private String description;
    private Integer ordre;
    private Boolean actif;
    private String hl7;
}
