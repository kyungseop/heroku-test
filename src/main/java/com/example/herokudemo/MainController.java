package com.example.herokudemo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/hi")
    public ResponseEntity<String> sayHi() {
        return ResponseEntity.ok("hi");
    }
}
