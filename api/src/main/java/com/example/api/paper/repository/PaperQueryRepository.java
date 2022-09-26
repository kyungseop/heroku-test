package com.example.api.paper.repository;

import com.example.api.paper.domain.PaperEntity;
import com.example.api.paper.domain.QPaperEntity;
import com.example.api.paper.model.command.request.PaperSearchRequest;
import com.example.api.paper.model.command.response.PaperResponse;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static com.example.api.paper.domain.QPaperEntity.paperEntity;

@Repository
public class PaperQueryRepository extends QuerydslRepositorySupport {

    public PaperQueryRepository() {
        super(PaperEntity.class);
    }

    public QueryResults<PaperResponse> search(PaperSearchRequest searchRequest, Pageable pageable) {
        return getQuerydsl().createQuery()
                            .select(
                                    Projections.constructor(
                                            PaperResponse.class,
                                            paperEntity.id,
                                            paperEntity.title,
                                            paperEntity.subTitle,
                                            paperEntity.imageUrl,
                                            paperEntity.publishDate
                                    )
                            ).from(paperEntity)
                            .where(
                                    hasTitle(searchRequest))
                            .orderBy(paperEntity.id.desc())
                            .offset(pageable.getOffset())
                            .limit(pageable.getPageSize())
                            .fetchResults();
    }

    private BooleanExpression hasTitle(PaperSearchRequest searchRequest) {
        return Objects.nonNull(searchRequest.getTitle()) ? paperEntity.title.eq(searchRequest.getTitle()) : null;
    }
}
