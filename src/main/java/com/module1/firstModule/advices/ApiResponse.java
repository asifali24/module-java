package com.module1.firstModule.advices;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class ApiResponse<T> {

    @Builder.Default
    private LocalDateTime timeStamp = LocalDateTime.now();
    private T data;
    private ApiError error;
}
