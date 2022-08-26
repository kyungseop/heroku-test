package com.example.herokudemo.paper.converter;


import com.example.herokudemo.paper.domain.PaperEntity;
import com.example.herokudemo.paper.model.command.response.PaperResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaperConverter {

    public static PaperResponse convert(PaperEntity entity) {
        return PaperResponse.builder()
                            .id(entity.getId())
                            .title(entity.getTitle())
                            .subTitle(entity.getSubTitle())
                            .imageUrl(entity.getImageUrl())
                            .publishDate(entity.getPublishDate())
                            .build();
    }
}
