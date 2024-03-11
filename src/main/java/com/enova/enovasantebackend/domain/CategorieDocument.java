package com.enova.enovasantebackend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.YesNoConverter;

@Entity @Builder
@Data @AllArgsConstructor @NoArgsConstructor
public class CategorieDocument {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String code;
    private String libelle;
    private String description;
    private Integer ordre;
    @Convert(converter = YesNoConverter.class)
    private Boolean actif;
    private String hl7;
}
