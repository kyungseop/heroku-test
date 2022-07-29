package com.example.herokudemo.service;

import com.example.herokudemo.converter.HiConverter;
import com.example.herokudemo.domain.HiEntity;
import com.example.herokudemo.model.HiCreateRequest;
import com.example.herokudemo.model.HiDto;
import com.example.herokudemo.repository.HiRepository;
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
