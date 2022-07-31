package com.example.herokudemo.hi.service;

import com.example.herokudemo.hi.converter.HiConverter;
import com.example.herokudemo.hi.domain.HiEntity;
import com.example.herokudemo.hi.model.HiCreateRequest;
import com.example.herokudemo.hi.model.HiDto;
import com.example.herokudemo.hi.repository.HiRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HiService {

    private final HiRepository hiRepository;

    public Integer create(HiCreateRequest msg) {
        HiEntity hiEntity = new HiEntity(msg.getMsg());
        hiRepository.save(hiEntity);
        return hiEntity.getId();
    }

    public List<HiDto> getAllHiList() {
        return hiRepository.findAll().stream().map(HiConverter::convert).collect(Collectors.toList());
    }

}
