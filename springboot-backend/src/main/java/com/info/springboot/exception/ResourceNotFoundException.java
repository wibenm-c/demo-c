package com.info.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <p>
 * Title: ResourceNotFoundException
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
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
