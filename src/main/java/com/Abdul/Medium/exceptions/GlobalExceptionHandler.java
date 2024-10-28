package com.Abdul.Medium.exceptions;

import com.Abdul.Medium.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{

       @ExceptionHandler(ResourceNoutFoundException.class)
       public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNoutFoundException ex)
       {
              String message = ex.getMessage();
              ApiResponse apiResponse = new ApiResponse(message, false);
              return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
       }

}
