package com.spring.jpa.chap05_practice.service;

import com.spring.jpa.chap05_practice.dto.PageDTO;
import com.spring.jpa.chap05_practice.dto.PostDetailResponseDTO;
import com.spring.jpa.chap05_practice.dto.PostListResponseDTO;
import com.spring.jpa.chap05_practice.entity.Post;
import com.spring.jpa.chap05_practice.repository.HashTagRepository;
import com.spring.jpa.chap05_practice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional //JPA 레파지토리는 트랜잭션 단위로 동작하기 떄문에 작성해야한다.
public class PostService {

    private final PostRepository postRepository;
    private final HashTagRepository hashTagRepository;

    public PostListResponseDTO getPosts(PageDTO dto) {

        //Pageable 객체 생상
        Pageable pageable = PageRequest.of(
            dto.getPage() - 1,
                dto.getSize(),
                Sort.by("createDate").descending()
        );

        //데이터베이스에서 게시물 목록 조회
        Page<Post> posts = postRepository.findAll(pageable);
        
        //게시물 정보만 꺼내기
        List<Post> postList = posts.getContent();

        List<PostDetailResponseDTO> postDetailResponseDTOList =

        //DB에서 조회한 정보(Entity)를 Json 형태에 맞는 DTO로 변환
        PostListResponseDTO responseDTO = PostListResponseDTO.builder()
                .count() //총 게시물 수가 아니라 조회된 게시물 수
                .pageInfo()
                .posts()
                .build();

        return responseDTO;
    }
}
