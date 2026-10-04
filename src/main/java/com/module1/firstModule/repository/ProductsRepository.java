package com.module1.firstModule.repository;

import com.module1.firstModule.entities.ProductsEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity,Long> {
    List<ProductsEntity> findByTitleContainsIgnoreCase(String title, Sort sort);
}
