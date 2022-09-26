package com.example.api.paper.service;

import com.example.api.exception.PaperNotFoundException;
import com.example.api.paper.converter.PaperConverter;
import com.example.api.paper.domain.PaperEntity;
import com.example.api.paper.model.command.request.PaperCreateRequest;
import com.example.api.paper.model.command.request.PaperSearchRequest;
import com.example.api.paper.model.command.request.PaperUpdateRequest;
import com.example.api.paper.model.command.response.PaperResponse;
import com.example.api.paper.repository.PaperQueryRepository;
import com.example.api.paper.repository.PaperRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.querydsl.core.QueryResults;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaperService {

    private final PaperRepository paperRepository;
    private final PaperQueryRepository paperQueryRepository;

    public Long create(PaperCreateRequest request) {
        PaperEntity paperEntity = PaperEntity.create(request);
        paperRepository.save(paperEntity);
        return paperEntity.getId();
    }

    public PaperResponse getPaper(Long id) {
        Optional<PaperEntity> opPaper = paperRepository.findById(id);
        return opPaper.map(PaperEntity::to).orElseThrow(() -> new PaperNotFoundException("Paper (" + id + ") was not found."));
    }

    @Transactional(readOnly = true)
    public Page<PaperResponse> search(PaperSearchRequest request, Pageable pageable) {
        QueryResults<PaperResponse> results = paperQueryRepository.search(request, pageable);
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    @Transactional
    public void update(Long id, PaperUpdateRequest request) {
        Optional<PaperEntity> opPaper = paperRepository.findById(id);
        //TODO heroku 에서 java 11 version update 방법 확인하여 optional 구문 변경
        if (opPaper.isPresent()) {
            PaperEntity paperEntity = opPaper.get();
            paperEntity.update(request);
        } else {
            throw new PaperNotFoundException("Paper (" + id + ") was not found.");
        }
    }

    public void remove(Long id) {
        paperRepository.deleteById(id);
    }
}
