package com.spring.jpa.chap05_practice.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostListResponseDTO {

    private int count;
    private PageResponseDTO pageInfo; //페이지 렌덩 정보
    private List<PostDetailResponseDTO> posts;// 게시물 렌더링 정보
}
