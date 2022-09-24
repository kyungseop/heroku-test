package com.example.api.exception;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class ApiExceptionAdvice {


    @ExceptionHandler({PaperNotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(HttpServletRequest request, Exception e) {
        log.warn("request method : {}, request url: {}, error : {}", request.getMethod(), request.getRequestURI(), e);
        //TODO 적절한 응답값으로 반환
        return ResponseEntity.notFound().build();
    }

}
