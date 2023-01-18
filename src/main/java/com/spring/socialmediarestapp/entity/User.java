package com.spring.socialmediarestapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("user_name")
    private String userName;
    private String email;
    private String password;
    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date startTime;

    @JsonProperty("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date endTime;

    @JsonProperty("created_time")
    @JsonFormat(pattern = "HH:mm", timezone = "UTC")
    private Date createdTime;

    @JsonProperty("modified_time")
    @JsonFormat(pattern = "HH:mm:ss", timezone = "UTC")
    private Date modifiedTime;

}
