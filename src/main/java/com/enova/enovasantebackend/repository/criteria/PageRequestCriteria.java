package com.enova.enovasantebackend.repository.criteria;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class PageRequestCriteria {
    private Integer pageNo = 0;
    private Integer pageSize = 10;
    private Sort.Direction sort = Sort.Direction.ASC;
    private String sortByColumn = "id";

    public Pageable getPageable() {
        return PageRequest.of(pageNo, pageSize, sort, sortByColumn);
    }
}
