package com.example.herokudemo.paper.controller;


import com.example.herokudemo.paper.model.command.request.PaperCreateRequest;
import com.example.herokudemo.paper.model.command.request.PaperUpdateRequest;
import com.example.herokudemo.paper.model.command.response.PaperResponse;
import com.example.herokudemo.paper.service.PaperService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PaperController {

    private final PaperService paperService;


    @PostMapping("/papers")
    public ResponseEntity<Long> createPaper(@RequestBody @Valid PaperCreateRequest request) {
        return ResponseEntity.ok(paperService.create(request));
    }

    @GetMapping("/papers")
    public ResponseEntity<List<PaperResponse>> getPaperList(@RequestParam(defaultValue = "1") Integer page,
                                                            @RequestParam(defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(paperService.getAlLPaperList());
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
