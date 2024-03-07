package com.enova.enovasantebackend.service.impl;

import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.dto.CategorieDocumentRequestDTO;
import com.enova.enovasantebackend.dto.CategorieDocumentResponseDTO;
import com.enova.enovasantebackend.exception.CategorieDocumentNotFoundException;
import com.enova.enovasantebackend.mapper.CategorieDocumentMapper;
import com.enova.enovasantebackend.repository.CategorieDocumentRepository;
import com.enova.enovasantebackend.service.CategorieDocumentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategorieDocumentServiceImpl implements CategorieDocumentService {
    CategorieDocumentRepository categorieDocumentRepository;
    CategorieDocumentMapper categorieDocumentMapper;

    @Override
    public List<CategorieDocumentResponseDTO> getAll() {
        return categorieDocumentRepository.findAll().stream().map(categorieDocumentMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public CategorieDocumentResponseDTO getById(String id) throws CategorieDocumentNotFoundException {
        return categorieDocumentMapper.toResponse(categorieDocumentRepository.findById(id).orElseThrow(() -> new CategorieDocumentNotFoundException("The CategorieDocument of the id " + id + "is not found")));
    }

    @Override
    public CategorieDocumentResponseDTO save(CategorieDocumentRequestDTO request) {
        CategorieDocument save = categorieDocumentRepository.save(categorieDocumentMapper.toEntity(request));
        return categorieDocumentMapper.toResponse(save);
    }

    @Override
    public CategorieDocumentResponseDTO update(CategorieDocumentRequestDTO request, String id) {
        CategorieDocument entity = categorieDocumentRepository.findById(id).get();
        BeanUtils.copyProperties(request, entity);
        return categorieDocumentMapper.toResponse(categorieDocumentRepository.save(entity));
    }

    @Override
    public void delete(String id) {
        categorieDocumentRepository.deleteById(id);
    }

    @Override
    public List<CategorieDocumentResponseDTO> getByCode(String code) {
        return categorieDocumentRepository.findCategorieDocumentsByCode(code).stream().map(categorieDocumentMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public Page<CategorieDocument> getBySpecification(Specification<CategorieDocument> specification, Pageable pageable) {
        return categorieDocumentRepository.findAll(specification, pageable);
    }

    @Override
    public Page<CategorieDocumentResponseDTO> getPage(Pageable page) {
        return categorieDocumentRepository.findAll(page).map(categorieDocumentMapper::toResponse);
    }
}
