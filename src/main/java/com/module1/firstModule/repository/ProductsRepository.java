package com.module1.firstModule.repository;

import com.module1.firstModule.dto.CGetProducts;
import com.module1.firstModule.dto.IgetProducts;
import com.module1.firstModule.entities.ProductsEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity,Long> {
    Page<ProductsEntity> findByTitleContainsIgnoreCase(String title, Pageable pagination);


    @Query("Select p.id as id , p.title as title from ProductsEntity p")
    List<IgetProducts> findProductWithI();


    @Query("select new com.module1.firstModule.dto.CGetProducts(p.id,p.title,p.type ) from ProductsEntity p order by title desc")
    List<CGetProducts> findAllProductsC();

    //for createtion

    @Transactional
    @Modifying
    @Query("Update ProductsEntity p set p.prise=:prise where p.id=:id")
    int updatePrice(int prise, Long id);
}
