package com.example.api.paper.model.command.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PaperSearchRequest {
    private String title;
//    private String subTitle;
//    private String imageUrl;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private String publishDate;
}
