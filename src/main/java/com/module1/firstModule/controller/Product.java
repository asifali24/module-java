package com.module1.firstModule.controller;

import com.module1.firstModule.entities.ProductsEntity;
import com.module1.firstModule.repository.ProductsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class Product {

    private  ProductsRepository productsRepository;

    public Product(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProductsEntity>> get(){
        Sort sort = Sort.by(Sort.Direction.ASC ,"sku");
        List<ProductsEntity> pro = productsRepository.findByTitleContainsIgnoreCase("PHONE",sort);
        return ResponseEntity.status(HttpStatus.OK).body(pro);
    }
}
