package com.spring.jpa.chap05_practice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.jpa.chap05_practice.entity.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class PostDetailResponseDTO {

    private String author;
    private String title;
    private String content;
    private List<String> hashTags;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime regDate;

    //엔터티를 DTO로 변환하는 생성자
    public PostDetailResponseDTO(Post post) {
        this.author = post.getWriter();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.regDate = post.getCreateDate();

        //HashTag같은 경우에는 가공해서 집어넣어야한다. (리스트의 타입이 서로 다름.)
        this.hashTags = post.getHashTags();
    }
}
