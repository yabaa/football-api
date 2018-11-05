package com.github.yabaa.footballapi.config;

import com.github.yabaa.footballapi.dto.ErrorBody;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorBody handleException(NotFoundException e) {
        log.info("A NotFoundException occured ", e);
        return toErrorBody(e.getMessage(), HttpStatus.NOT_FOUND.toString());
    }

    private static ErrorBody toErrorBody(String message, String returnCode) {
        return ErrorBody.builder()
                .returnCode(returnCode)
                .message(message)
                .build();
    }

}
