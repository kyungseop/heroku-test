package com.example.herokudemo.paper.model.command.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaperResponse {

    private Long id;
    private String title;
    private String subTitle;
    private String imageUrl;
    private LocalDateTime publishDate;

}
