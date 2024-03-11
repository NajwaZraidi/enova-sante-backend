package com.enova.enovasantebackend.repository.criteria;


import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Objects;

@Data
public class PageRequestDTO {

    private Integer current_page = 0 ;
    private Integer page_size = 10;
    private Sort.Direction sort = Sort.Direction.ASC;
    private String sortByColumn = "ordre";

    public Pageable getPageable(PageRequestDTO dto){
        Integer page = Objects.nonNull(dto.getCurrent_page()) ? dto.current_page : this.current_page;
        Integer size = Objects.nonNull(dto.getPage_size()) ? dto.page_size : this.page_size;
        Sort.Direction sort = Objects.nonNull(dto.getSort()) ? dto.sort : this.sort;
        String sortByColumn = Objects.nonNull(dto.getSortByColumn()) ? dto.sortByColumn : this.sortByColumn;
        PageRequest pageRequest = PageRequest.of(page, size,sort,sortByColumn);
     return pageRequest;
    }
}
