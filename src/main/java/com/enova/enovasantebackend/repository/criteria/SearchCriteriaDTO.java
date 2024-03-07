package com.enova.enovasantebackend.repository.criteria;

import com.enova.enovasantebackend.enums.GlobalOperator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteriaDTO {
     private String colonne;
    private String value;
    private GlobalOperator operator=GlobalOperator.EQUAL;
}
