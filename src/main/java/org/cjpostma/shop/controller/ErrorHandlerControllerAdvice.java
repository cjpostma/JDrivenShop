package org.cjpostma.shop.controller;


import org.cjpostma.shop.exception.WebError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(ErrorHandlerControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<WebError> handleInternalServerError(Exception error) {
        logger.error(error.getMessage(), error);
        WebError webError = new WebError("An Internal exception occurred in the application");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(webError);
    }
}