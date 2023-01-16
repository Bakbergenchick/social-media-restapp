package com.spring.socialmediarestapp.utils.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PostDTO {

    @NotNull(message = "Title is required")
    @NotEmpty(message = "Field is not filled")
    @Length(min = 1, max = 30, message = "Invalid length of title")
    private String title;

    @NotNull(message = "Description is required")
    @NotEmpty(message = "Field is not filled")
    @Length(min = 1, max = 30, message = "Invalid length of description")
    private String description;

    @Max(6)
    @Min(1)
    @NotNull(message = "Field is not filled")
    private Integer commentsAmount;

    @NotNull(message = "Content is required")
    @NotEmpty(message = "Field is not filled")
    @Length(min = 1, max = 30, message = "Invalid length of content")
    private String content;

//    private String phoneNumber;
}
