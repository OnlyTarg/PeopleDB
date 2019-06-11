package com.person.demo.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    public void saveImage(Long id, MultipartFile file) throws IOException;
}
