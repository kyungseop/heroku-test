package com.example.api.paper.controller;


import com.example.api.paper.model.command.request.PaperCreateRequest;
import com.example.api.paper.model.command.request.PaperSearchRequest;
import com.example.api.paper.model.command.request.PaperUpdateRequest;
import com.example.api.paper.model.command.response.PaperResponse;
import com.example.api.paper.service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PaperController {

    private final PaperService paperService;


    @PostMapping("/papers")
    public ResponseEntity<Long> createPaper(@RequestBody @Valid PaperCreateRequest request) {
        return ResponseEntity.ok(paperService.create(request));
    }

    @GetMapping("/papers")
    public ResponseEntity<Page<PaperResponse>> search(PaperSearchRequest searchRequest, Pageable pageable) {
        return ResponseEntity.ok(paperService.search(searchRequest, pageable));
    }

    @GetMapping("/papers/{id}")
    public ResponseEntity<PaperResponse> getPaper(@PathVariable Long id) {
        return ResponseEntity.ok(paperService.getPaper(id));
    }


    @PutMapping("/papers/{id}")
    public ResponseEntity<Void> updatePaper(@PathVariable Long id, @RequestBody @Valid PaperUpdateRequest request) {
        paperService.update(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/papers/{id}")
    public ResponseEntity<Void> removePaper(@PathVariable Long id) {
        paperService.remove(id);
        return ResponseEntity.ok().build();
    }


}
