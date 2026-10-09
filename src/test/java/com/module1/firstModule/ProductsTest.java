package com.module1.firstModule;


import com.module1.firstModule.dto.CGetProducts;
import com.module1.firstModule.dto.IgetProducts;
import com.module1.firstModule.entities.ProductsEntity;
import com.module1.firstModule.repository.ProductsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductsTest {

    @Autowired
    ProductsRepository productsRepository;

    @Test
    void getProductsWithoutAnyAttributes(){

        List<ProductsEntity> getAll = productsRepository.findAll();

        for(var p : getAll){
            System.out.println(p);
        }
    }


    @Test
    void getProductWithAttributesAndInterfaceImpl(){
        List<IgetProducts> getAll = productsRepository.findProductWithI();

        for(IgetProducts p : getAll){
            System.out.println(p.toString());
        }
    }

    @Test
    void getProductWithAttributesAndConcreatImpl(){
        List<CGetProducts> getAll = productsRepository.findAllProductsC();
        for(var p : getAll){
            System.out.println(p.toString());
        }
    }


    //update of product

    @Test
    void updateProductWithId(){
        int updatedCount = productsRepository.updatePrice(100000,1L);
        System.out.println(updatedCount);
    }
}
