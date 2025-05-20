package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class TestController {

    @GetMapping(path = "/hi")
    public ApiResponse Hi() {
        return ApiResponse.ok();
    }
}
