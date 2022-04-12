package com.info.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/**
 * <p>
 * Title: CustomGlobalExceptionHandler
 * </p>
 * <p>
 * Description:
 * //TODO : WIBEN
 * </p>
 * <p>
 * Copyright Notice
 * ================
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2017
 * <p>
 * </p>
 *
 * @author WIBEN
 * @version 1.0
 * @created 24/03/2022
 */
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessTransactionException.class)
    public ResponseEntity<CustomMessageResponse> customHandleNotFound(Exception ex, WebRequest request) {

        CustomMessageResponse errors = new CustomMessageResponse();
        errors.setTimestamp(LocalDateTime.now().now());
        errors.setMessage(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_ACCEPTABLE.value());

        return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);

    }

    //...
}
