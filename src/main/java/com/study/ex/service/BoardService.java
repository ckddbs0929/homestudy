package com.study.ex.service;

import com.study.ex.entity.Board;
import com.study.ex.entity.BoardRepository;
import com.study.ex.entity.BoardRequestDto;
import com.study.ex.entity.BoardResponseDto;
import com.study.ex.exception.CustomException;
import com.study.ex.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardRequestDto request){
        Board entity = boardRepository.save(request.toEntity());
        return entity.getId();
    }

    public List<BoardResponseDto> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id", "createDate");
        List<Board> list = boardRepository.findAll(sort);
        /*return list.stream().map(BoardResponseDto::new).collect(Collectors.toList()); -> 밑의 코드랑 같은 뜻*/
        List<BoardResponseDto> boardList = new ArrayList<>();
        for(Board entity : list){
            boardList.add(new BoardResponseDto(entity));
        }
        return boardList;
    }

    @Transactional
    public Long update(Long id, BoardRequestDto request){
        /*Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));*/
        Board entity = boardRepository.findById(id).orElse(null);
        if(entity == null){
            throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
        }
        entity.update(request.getTitle(), request.getContent(), request.getWriter());
        return id;
    }
}
