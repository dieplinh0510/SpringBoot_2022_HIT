package com.example.ktra_1.services;

import org.springframework.web.multipart.MultipartFile;

public interface SendMailService {
    String sendMailWithText(String sub, String content, String to);
    String sendMailWithAtt(String sub, String content, String to, MultipartFile[] att);
}
