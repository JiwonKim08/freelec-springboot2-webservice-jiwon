package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") //게시물 등록
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    } //DB에 저장

    @PutMapping("/api/v1/posts/{id}") //게시물 수정
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto); //DB table 업데이트
    }

    @DeleteMapping("/api/v1/posts/{id}") //게시물 삭제
    public Long delete(@PathVariable Long id) {
        postsService.delete(id); //DB table에서 삭제한 후 DB에서 영구삭제
        return id;
    }

    @GetMapping("/api/v1/posts/{id}") //특정 게시물 조회
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    } //테이블 값 리턴

    @GetMapping("/api/v1/posts/list") //모든 게시물 조회
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }
}
