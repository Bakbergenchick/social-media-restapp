package com.spring.socialmediarestapp.errors;

import com.spring.socialmediarestapp.utils.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BaseResponse> handlerResourceNotFound(ResourceNotFoundException ex){
        BaseResponse baseResponse = BaseResponse.builder()
                .data(HttpStatus.NOT_FOUND.toString())
                .success(false)
                .code(ex.getLocalizedMessage())
                .build();

        return new ResponseEntity<>(baseResponse, HttpStatus.NOT_FOUND);
    }


//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatusCode status,
//                                                                  WebRequest request) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult()
//                .getAllErrors()
//                .forEach(objectError -> {
//                    String field = ((FieldError)objectError).getField();
//                    String message = objectError.getDefaultMessage();
//
//                    errors.put(field, message);
//                });
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getAllErrors()
                .forEach(objectError -> {
                    String field = ((FieldError)objectError).getField();
                    String message = objectError.getDefaultMessage();

                    errors.put(field, message);
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
