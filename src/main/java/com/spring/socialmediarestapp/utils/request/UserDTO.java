package com.spring.socialmediarestapp.utils.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.TimeZone;

@Data
public class UserDTO {

    @JsonProperty("username")
    private String userName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date startTime;

    @JsonProperty("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date endTime;
}
