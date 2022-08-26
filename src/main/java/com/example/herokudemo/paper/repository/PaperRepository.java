package com.example.herokudemo.paper.repository;

import com.example.herokudemo.paper.domain.PaperEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperRepository extends CrudRepository<PaperEntity, Long> {

    List<PaperEntity> findAll();
}
