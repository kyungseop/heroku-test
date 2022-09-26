package com.example.api.paper.model.command.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PaperResponse {

    private Long id;
    private String title;
    private String subTitle;
    private String imageUrl;
    private LocalDateTime publishDate;

}
