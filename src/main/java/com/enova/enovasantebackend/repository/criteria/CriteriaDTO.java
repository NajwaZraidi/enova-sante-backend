package com.enova.enovasantebackend.repository.criteria;

import com.enova.enovasantebackend.enums.GlobalOperator;
import lombok.Data;

import java.util.List;

@Data
public class CriteriaDTO {
    List<SearchCriteriaDTO> searchCriteriaDTO;
    GlobalOperator globalOperator=GlobalOperator.AND;
}
