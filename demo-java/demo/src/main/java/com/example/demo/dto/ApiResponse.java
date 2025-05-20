package com.example.demo.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private String msg = "success";
    private int code;

    public static <M> ApiResponse<M> ok() {
        return new ApiResponse();
    }
}
