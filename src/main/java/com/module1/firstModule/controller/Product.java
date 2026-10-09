package com.module1.firstModule.controller;

import com.module1.firstModule.entities.ProductsEntity;
import com.module1.firstModule.repository.ProductsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class Product {

    private  ProductsRepository productsRepository;
    private int pageSize = 10;

    public Product(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping
    public ResponseEntity<Page<ProductsEntity>> get(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "DESC") String orderBy,
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "0") int pageNo
    ){

        Sort sort = Sort.by(Sort.Direction.fromString(orderBy) ,sortBy);

        Pageable pagination = PageRequest.of(pageNo,pageSize,sort);

        Page<ProductsEntity> pro = productsRepository.findByTitleContainsIgnoreCase(title,pagination);
        return ResponseEntity.status(HttpStatus.OK).body(pro);
    }
}
