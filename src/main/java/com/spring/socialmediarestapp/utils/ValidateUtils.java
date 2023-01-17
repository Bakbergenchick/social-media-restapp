package com.spring.socialmediarestapp.utils;

import lombok.Builder;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Builder
public class ValidateUtils {

    private Object value;
    private boolean required;
    private Integer maxLength;
    private String fieldName;
    private String regex;
    private boolean onlyNumber;
    private boolean isInteger;
    private Long max;
    private Long min;
    private String message;
    private final String ONLY_NUMBER = "[0-9]+";

    public Map validate() {
        Map<String, String> errors = new HashMap<>();

        // checks field is required
        if (required && ObjectUtils.isEmpty(value)
                && !ObjectUtils.isEmpty(fieldName)) {
            errors.put(fieldName, fieldName + " is required");
        }

        // checks max length of value
        if (!ObjectUtils.isEmpty(maxLength) && !ObjectUtils.isEmpty(value)
                && value.toString().length() > maxLength
                && !ObjectUtils.isEmpty(fieldName)) {
            errors.put(fieldName, fieldName + " must have 0 or " + maxLength + " characters");
        }

        // checks field name for number characters
        if (onlyNumber && !ObjectUtils.isEmpty(value)
                && !ObjectUtils.isEmpty(fieldName)) {
            Pattern pattern = Pattern.compile(ONLY_NUMBER);
            Matcher matcher = pattern.matcher(value.toString());

            if (!matcher.matches()) {
                errors.put(fieldName, fieldName + " must contain only numbers");
            }
        }

        // checks field name is integer
        if (isInteger && !ObjectUtils.isEmpty(value)
                && !ObjectUtils.isEmpty(fieldName)) {
            try {
                Integer.parseInt(value.toString());
            } catch (Exception e) {
                errors.put(fieldName, fieldName + " must be integer number");
            }
        }

        // checks field is outing of range
        if (!ObjectUtils.isEmpty(max) && !ObjectUtils.isEmpty(min)
                && !ObjectUtils.isEmpty(value)
                && !ObjectUtils.isEmpty(fieldName)){
            try{
                Long v = Long.parseLong(value.toString());
                if (v > max || v < min){
                    errors.put(fieldName, fieldName + " must range from " + min + " to " + max);
                }
            }catch (Exception e){
                errors.put(fieldName, fieldName + " is invalid input");
            }
        }
        return errors;
    }
}
