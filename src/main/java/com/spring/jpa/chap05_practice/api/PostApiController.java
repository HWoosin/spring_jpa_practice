package com.spring.jpa.chap05_practice.api;

import com.spring.jpa.chap05_practice.dto.PageDTO;
import com.spring.jpa.chap05_practice.dto.PostCreateDTO;
import com.spring.jpa.chap05_practice.dto.PostDetailResponseDTO;
import com.spring.jpa.chap05_practice.dto.PostListResponseDTO;
import com.spring.jpa.chap05_practice.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
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

    @GetMapping
    public ResponseEntity<?> list(PageDTO pageDTO) {
        log.info("/api/v1/post?page={}=&size={}",pageDTO.getPage(),pageDTO.getSize());

        PostListResponseDTO dto = postService.getPosts(pageDTO);
        return ResponseEntity
                .ok()
                .body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable long id){
        log.info("/spi/v1/post/{}:GET");

        try {
            PostDetailResponseDTO dto = postService.getDetail(id);
            return ResponseEntity.ok().body(dto);//문제가 없다면 이렇게 처리.
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody PostCreateDTO dto, BindingResult result) {//검증 에러 정보를 가진 객체
        log.info("api/v1/posts:POST - payload: {}",dto);

        if(dto == null){
            return ResponseEntity.badRequest().body("등록 게시물 정보를 전달해 주세요!");
        }
        if(result.hasErrors()){ //입력값 검증에 걸림
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(err ->{
                log.warn("invalid client data - {}", err.toString());
            });
            return ResponseEntity.badRequest().body(fieldErrors);
        }
        PostDetailResponseDTO responseDTO = postService.insert(dto);
    }
}
