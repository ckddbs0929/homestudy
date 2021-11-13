package com.study.ex.controller;


import com.study.ex.entity.BoardRequestDto;
import com.study.ex.entity.BoardResponseDto;
import com.study.ex.exception.CustomException;
import com.study.ex.exception.ErrorCode;
import com.study.ex.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/test")
    public String test(){
        throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
    }

    // 게시글 리스트 조회
    @GetMapping("/boards")
    public List<BoardResponseDto> findAll(){
        return boardService.findAll();
    }

    // 게시글 생성
    @PostMapping("/boards")
    public Long save(@RequestBody BoardRequestDto request){
        return boardService.save(request);
    }

    // 게시글 수정
    @PatchMapping("/boards/{id}")
    public Long save(@PathVariable Long id, @RequestBody BoardRequestDto request){
        return boardService.update(id, request);
    }
}
