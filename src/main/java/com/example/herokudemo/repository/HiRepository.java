package com.example.herokudemo.repository;

import com.example.herokudemo.domain.HiEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiRepository extends CrudRepository<HiEntity, Integer> {

    List<HiEntity> findAll();
}
