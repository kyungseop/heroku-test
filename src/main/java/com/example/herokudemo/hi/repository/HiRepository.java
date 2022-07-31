package com.example.herokudemo.hi.repository;

import com.example.herokudemo.hi.domain.HiEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiRepository extends CrudRepository<HiEntity, Integer> {

    List<HiEntity> findAll();
}
