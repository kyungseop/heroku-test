package com.example.herokudemo.hi.converter;


import com.example.herokudemo.hi.domain.HiEntity;
import com.example.herokudemo.hi.model.HiDto;
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
