package com.module1.firstModule.dto;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    @NotBlank(message = "Name cant be empty")
    private String name;

    @Email(message = "Email cant be empty")
    private String email;

    @NotNull(message = "status is required")
    private Boolean isActive;

    @Positive(message = "Age can't be negative")
    @Min(value = 18,message = "Min age should be 18")
    @Max(value = 60,message = "Max age can be 60")
    private int age;
}
