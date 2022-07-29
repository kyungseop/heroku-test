package com.example.herokudemo.converter;


import com.example.herokudemo.domain.HiEntity;
import com.example.herokudemo.model.HiDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HiConverter {

    public static HiDto convert(HiEntity entity) {
        return HiDto.builder()
                    .id(entity.getId())
                    .msg(entity.getMsg())
                    .build();
    }
}
