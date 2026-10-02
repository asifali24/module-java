package com.module1.firstModule.advices;


import com.module1.firstModule.exceptions.ResourcesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> resourcesNotFoundException(ResourcesNotFoundException exception){
        ApiError err = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(formateError(err));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> validationErrors(MethodArgumentNotValidException exception){
        List<String> errors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map((e)-> e.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError err = ApiError.builder()
                .message("invalid input Validation")
                .status(HttpStatus.BAD_REQUEST)
                .errorList(errors)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(formateError(err));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> internalServerError(Exception exc){
        ApiError err = ApiError
                .builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message("Internal Server Error")
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(formateError(err));
    }


    private ApiResponse<?>  formateError(ApiError err){
        return  ApiResponse.builder()
                .error(err)
                .build();
    }
}
