package com.example.api.paper.model.command.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PaperCreateRequest {

    @NotBlank
    private String title;
    private String subTitle;
    private String imageUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String publishDate;
}
