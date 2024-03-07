package com.enova.enovasantebackend.service.impl;

import com.enova.enovasantebackend.enums.GlobalOperator;
import com.enova.enovasantebackend.repository.criteria.SearchCriteriaDTO;
import com.enova.enovasantebackend.domain.CategorieDocument;
import com.enova.enovasantebackend.dto.CategorieDocumentRequestDTO;
import com.enova.enovasantebackend.dto.CategorieDocumentResponseDTO;
import com.enova.enovasantebackend.exception.CategorieDocumentNotFoundException;
import com.enova.enovasantebackend.mapper.CategorieDocumentMapper;
import com.enova.enovasantebackend.repository.CategorieDocumentRepository;
import com.enova.enovasantebackend.repository.specification.FiltreSpecification;
import com.enova.enovasantebackend.service.CategorieDocumentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategorieDocumentServiceImpl implements CategorieDocumentService {
    CategorieDocumentRepository categorieDocumentRepository;
    CategorieDocumentMapper categorieDocumentMapper;
    FiltreSpecification<CategorieDocument> CategorieFilterSpecification;
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
    public Page<CategorieDocumentResponseDTO> getAllDocumentCategorie(int page, int size) {
        return categorieDocumentRepository.findAll(PageRequest.of(page, size)).map(categorieDocumentMapper::toResponse);
    }

    @Override
    public CategorieDocumentResponseDTO getCategorieByCode(String code) {
        return categorieDocumentMapper.toResponse(categorieDocumentRepository.findByCode(code));
    }



    @Override
    public List<CategorieDocumentResponseDTO> getCategoriesByCriteria(List<SearchCriteriaDTO> searchCriteriaDTO, GlobalOperator operator) {
            Specification<CategorieDocument> specification= CategorieFilterSpecification.getSearchSpecification(searchCriteriaDTO,operator);
            return categorieDocumentRepository.findAll(specification).stream().map(categorieDocumentMapper::toResponse).collect(Collectors.toList());
    }


}
