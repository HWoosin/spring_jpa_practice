package com.spring.jpa.chap05_practice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.jpa.chap05_practice.entity.HashTag;
import com.spring.jpa.chap05_practice.entity.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        this.hashTags = post.getHashTags()//List<HashTag>
                            .stream()//stream 객체를 받아옴.(컬렉션 데이터를 함수 선언 형신으로 처리할 수 있게 해주는 객체)
                            //스트림 내의 요소들에 대해 함수가 적용된 결과를 새로운 요소로 맵핑.
                            .map(HashTag::getTagName)
                            //스크림 객체를 새로운 리스트의 형태로 리턴. ->this.hashTags에게 대입.
                            .collect(Collectors.toList());

    }
}
