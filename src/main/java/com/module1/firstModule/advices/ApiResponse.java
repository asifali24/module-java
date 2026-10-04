package com.module1.firstModule.advices;

import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;


@Data
@Builder
@JsonPropertyOrder({"status", "timeStamp", "data", "error" })
public class ApiResponse<T> {

    @Builder.Default
    private LocalDateTime timeStamp = LocalDateTime.now();
    private T data;
    private ApiError error;
    private  Boolean status;
}
