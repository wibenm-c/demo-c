package com.info.springboot.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * Title: CustomMessageResponse
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
 * @created 24 /03/2022
 */
public class CustomMessageResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String message;


    /**
     * Gets timestamp.
     *
     * @return Value of timestamp.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Gets message.
     *
     * @return Value of message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets new message.
     *
     * @param message New value of message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets status.
     *
     * @return Value of status.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets new status.
     *
     * @param status New value of status.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Sets new timestamp.
     *
     * @param timestamp New value of timestamp.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
