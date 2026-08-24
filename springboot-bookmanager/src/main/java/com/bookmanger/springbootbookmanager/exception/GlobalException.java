package com.bookmanger.springbootbookmanager.exception;

import com.bookmanger.springbootbookmanager.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleValidException(MethodArgumentNotValidException e){

        String msg = e.getBindingResult().getFieldError().getDefaultMessage();
        return Result.error(msg);
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return Result.error("服务器异常：" + e.getMessage());
    }
}
