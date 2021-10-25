package com.study.ex.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 컨트롤러 전역에서 발생할 수 있는 예외를 잡아 throw
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class) // 특정 클래스에서 발생할 수 있는 예외를 잡아 throw
    public String handleRuntimeException(final RuntimeException e){
        log.error("handleRuntimeException : {}", e.getMessage());
        return e.getMessage();
    }
}
