package com.project.BlogApp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.BlogApp.paylod.APIResponse;



//@ControllerAdvice
@RestControllerAdvice   // for working with rest api
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){

        String message = ex.getMessage();
        APIResponse apiResponse = new APIResponse(message, false);
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodExceptionHandler(MethodArgumentNotValidException ex){

        Map<String,String> errRes = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(e->{
            String filedName = ((FieldError)e).getField();
            String mesage =e.getDefaultMessage();

            errRes.put(filedName, mesage);
        });


        return new ResponseEntity<Map<String,String>>(errRes,HttpStatus.BAD_REQUEST);


    }
    
}
