package com.example.herokudemo.paper.service;

import com.example.herokudemo.exception.PaperNotFoundException;
import com.example.herokudemo.paper.converter.PaperConverter;
import com.example.herokudemo.paper.domain.PaperEntity;
import com.example.herokudemo.paper.model.command.request.PaperCreateRequest;
import com.example.herokudemo.paper.model.command.request.PaperUpdateRequest;
import com.example.herokudemo.paper.model.command.response.PaperResponse;
import com.example.herokudemo.paper.repository.PaperRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaperService {

    private final PaperRepository paperRepository;

    public Long create(PaperCreateRequest request) {
        PaperEntity paperEntity = PaperEntity.create(request);
        paperRepository.save(paperEntity);
        return paperEntity.getId();
    }

    public PaperResponse getPaper(Long id) {
        Optional<PaperEntity> opPaper = paperRepository.findById(id);
        return opPaper.map(PaperEntity::to).orElseThrow(() -> new PaperNotFoundException("Paper (" + id + ") was not found."));
    }

    public List<PaperResponse> getAlLPaperList() {
        return paperRepository.findAll().stream().map(PaperConverter::convert).collect(Collectors.toList());
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
}
