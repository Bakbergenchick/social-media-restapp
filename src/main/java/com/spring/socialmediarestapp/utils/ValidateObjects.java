package com.spring.socialmediarestapp.utils;

import com.spring.socialmediarestapp.utils.request.PostDTO;

import java.util.HashMap;
import java.util.Map;

public class ValidateObjects {

    public static Map<String, String> validatePostDTO(PostDTO postDTO) {
        Map<String, String> errors = new HashMap<>();

        errors.putAll(ValidateUtils.builder()
                .fieldName("title")
                .value(postDTO.getTitle())
                .required(true)
                .maxLength(20)
                .build().validate());

        errors.putAll(ValidateUtils.builder()
                .fieldName("description")
                .value(postDTO.getDescription())
                .required(false)
                .maxLength(50)
                .build().validate());

        errors.putAll(ValidateUtils.builder()
                .fieldName("commentsAmount")
                .value(postDTO.getCommentsAmount())
                .required(true)
                .isInteger(true)
                .min(Long.valueOf(1))
                .max(Long.valueOf(7))
                .build().validate());

        errors.putAll(ValidateUtils.builder()
                .fieldName("content")
                .value(postDTO.getContent())
                .required(true)
                .maxLength(20)
                .build().validate());

        errors.putAll(ValidateUtils.builder()
                .fieldName("phoneNumber")
                .value(postDTO.getPhoneNumber())
                .required(true)
                .maxLength(11)
                .onlyNumber(true)
                .build().validate());


        return errors;
    }
}
