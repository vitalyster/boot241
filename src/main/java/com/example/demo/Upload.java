package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Upload {
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile avatar) {
        return avatar.getName();
    }
}
