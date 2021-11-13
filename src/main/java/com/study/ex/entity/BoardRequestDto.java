package com.study.ex.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequestDto {
    // DTO를 사용하는 이유는 entity는 테이블 그 자체이므로 절대로 요청과 응답에 사용되어서는 안된다.
    // 따로 생성자(builder)를 사용해 따로 생성(구분)해줘야 함
    private String title;
    private String content;
    private String writer;
    private char deleteYn;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .hits(0)
                .deleteYn(deleteYn)
                .build();
    }
}
