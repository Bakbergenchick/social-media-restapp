package com.spring.socialmediarestapp.utils.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PostDTO {

    private String title;

    private String description;

    private Integer commentsAmount;

    private String content;

    private String phoneNumber;
}
