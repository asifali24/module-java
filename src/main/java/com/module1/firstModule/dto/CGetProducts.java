package com.module1.firstModule.dto;

import com.module1.firstModule.entities.types.ProductsType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class CGetProducts {
    private final Long id;
    private final String title;
    private  final ProductsType type;
}
