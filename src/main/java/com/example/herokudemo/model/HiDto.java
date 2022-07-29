package com.example.herokudemo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HiDto {

    private Integer id;
    private String msg;

}
