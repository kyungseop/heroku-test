package com.example.herokudemo.hi.controller;


import com.example.herokudemo.hi.model.HiCreateRequest;
import com.example.herokudemo.hi.model.HiDto;
import com.example.herokudemo.hi.service.HiService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HiController {

    private final HiService hiService;

    @GetMapping("/hi")
    public List<HiDto> sayHi() {
        return hiService.getAllHiList();
    }

    @PostMapping("/hi")
    public Integer sayHi(@RequestBody HiCreateRequest msg) {
        return hiService.create(msg);
    }

}
