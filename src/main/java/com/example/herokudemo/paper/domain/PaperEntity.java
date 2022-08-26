package com.example.herokudemo.paper.domain;

import static com.example.herokudemo.paper.util.TimeUtils.DTF;

import com.example.herokudemo.paper.model.command.request.PaperCreateRequest;
import com.example.herokudemo.paper.model.command.request.PaperUpdateRequest;
import com.example.herokudemo.paper.model.command.response.PaperResponse;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
@Table(name = "paper")
public class PaperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private String subTitle;
    @Column
    private String imageUrl;
    @Column
    private LocalDateTime publishDate;
    @Column
    private String createBy;
    @Column
    private LocalDateTime createDate;
    @Column
    private String updateBy;
    @Column
    private LocalDateTime updateDate;


    public static PaperEntity create(PaperCreateRequest request) {

        return PaperEntity.builder()
                          .title(request.getTitle())
                          .subTitle(request.getSubTitle())
                          .imageUrl(request.getImageUrl())
                          .publishDate(LocalDateTime.parse(request.getPublishDate(), DTF))
                          .createBy("creator")
                          .createDate(LocalDateTime.now())
                          .updateBy("updater")
                          .updateDate(LocalDateTime.now())
                          .build();
    }

    public static PaperResponse to(PaperEntity entity) {
        return PaperResponse.builder()
                            .id(entity.getId())
                            .title(entity.getTitle())
                            .subTitle(entity.getSubTitle())
                            .publishDate(entity.getPublishDate())
                            .imageUrl(entity.getImageUrl())
                            .build();
    }

    public void update(PaperUpdateRequest request) {
        this.title = request.getTitle();
        this.subTitle = request.getSubTitle();
        this.imageUrl = request.getImageUrl();
        this.publishDate = LocalDateTime.parse(request.getPublishDate(), DTF);
    }

}


