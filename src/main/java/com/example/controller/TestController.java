package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping("/kh")
    public ResponseEntity<?> pageKH(){
        return new ResponseEntity<>("pageKH", HttpStatus.OK);
    }
}
