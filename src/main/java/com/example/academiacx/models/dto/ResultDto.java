package com.example.academiacx.models.dto;

public class ResultDto {
    String message;
    Integer status;

    public ResultDto(String message, Integer status) {

        this.message = message;
        this.status = status;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
