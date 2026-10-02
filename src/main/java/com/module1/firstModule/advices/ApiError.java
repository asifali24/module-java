package com.module1.firstModule.advices;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> errorList;
}
