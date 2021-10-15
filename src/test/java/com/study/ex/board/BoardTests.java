package com.study.ex.board;


import com.study.ex.entity.Board;
import com.study.ex.entity.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save(){

        // 게시글 파라미터 생성
        Board params = Board.builder().
                title("1번").
                content("내용").writer("창윤").hits(0).deleteYn('N').build();

        // 게시글 저장
        boardRepository.save(params);

        // 1번 게시글 조회
        Board entity = boardRepository.findById((long) 1).get();
        Assertions.assertThat(entity.getTitle()).isEqualTo("1번");
        Assertions.assertThat(entity.getContent()).isEqualTo("내용");
        Assertions.assertThat(entity.getWriter()).isEqualTo("창윤");

    }

    @Test
    void findAll(){

        // 전체 게시글 수 조회
        long boardsCount = boardRepository.count();

        // 전체 게시글 리스트 조회
        List<Board> list = boardRepository.findAll();

        System.out.println(boardsCount);
        System.out.println(list);
    }

    @Test
    void delete(){

        // findById로 1번 게시글을 entity라는 파라미터에 값을 전달한 후
        Board entity = boardRepository.findById((long) 1).get();

        // entity안에 들어있는 파라미터를 삭제제
        boardRepository.delete(entity);
    }
}
