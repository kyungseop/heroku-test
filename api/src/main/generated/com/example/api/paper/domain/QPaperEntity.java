package com.example.api.paper.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaperEntity is a Querydsl query type for PaperEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaperEntity extends EntityPathBase<PaperEntity> {

    private static final long serialVersionUID = 817666444L;

    public static final QPaperEntity paperEntity = new QPaperEntity("paperEntity");

    public final StringPath createBy = createString("createBy");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final DateTimePath<java.time.LocalDateTime> publishDate = createDateTime("publishDate", java.time.LocalDateTime.class);

    public final StringPath subTitle = createString("subTitle");

    public final StringPath title = createString("title");

    public final StringPath updateBy = createString("updateBy");

    public final DateTimePath<java.time.LocalDateTime> updateDate = createDateTime("updateDate", java.time.LocalDateTime.class);

    public QPaperEntity(String variable) {
        super(PaperEntity.class, forVariable(variable));
    }

    public QPaperEntity(Path<? extends PaperEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaperEntity(PathMetadata metadata) {
        super(PaperEntity.class, metadata);
    }

}

