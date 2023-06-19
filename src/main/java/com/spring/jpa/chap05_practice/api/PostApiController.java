package com.spring.jpa.chap05_practice.api;

import com.spring.jpa.chap05_practice.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/vi/posts")
public class PostApiController {

    //리소스: 게시물 (Post)
    /*
        게시물 목록 조회: /posts       - GET
        게시물 개별 조회: /posts/{id} - GET
        게시물 등록:     /posts      -POST
        게시물 수전:     /posts/{id} -PATCH
        게시물 삭제:     /posts/{id} -DELETE
     */

    private final PostService postService;
}
