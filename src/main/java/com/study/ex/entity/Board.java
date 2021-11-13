package com.study.ex.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 해당 클래스의 기본 생성자를 생성해줌
@Entity
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String writer;

    private int hits; // 조회수

    private char deleteYn; // 삭제 여부

    private LocalDateTime createDate = LocalDateTime.now(); // 생성일

    private LocalDateTime modifiedDate; // 수정일

    @Builder // 생성자를 대신해주는 것
    public Board(String title, String content, String writer, int hits, char deleteYn){
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
        this.deleteYn = deleteYn;
    }

    // 비즈니스 로직
    public void update(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.modifiedDate = LocalDateTime.now();
    }
}
