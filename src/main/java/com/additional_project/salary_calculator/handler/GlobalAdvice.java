package com.additional_project.salary_calculator.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
@Slf4j
public class GlobalAdvice {
    @ResponseBody
    @ExceptionHandler
    @ResponseStatus
    void fiveHundred(Exception ex, HttpServletResponse response) throws IOException {
        log.info(ex.getMessage());
        response.sendRedirect("/error");
    }
}