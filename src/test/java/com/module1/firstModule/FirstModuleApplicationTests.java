package com.module1.firstModule;

import com.module1.firstModule.entities.ProductsEntity;
import com.module1.firstModule.repository.ProductsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FirstModuleApplicationTests {

	@Autowired
	ProductsRepository productsRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createProduct() {
		ProductsEntity product = ProductsEntity.builder()
				.sku("abc-1")
				.title("def-1")
				.prise(1234)
				.build();

		ProductsEntity createdProduct = productsRepository.saveAndFlush(product);

		assertNotNull(createdProduct.getId());
		assertEquals("abc-1", createdProduct.getSku());
		assertEquals("def-1", createdProduct.getTitle());
	}

	@Test
	void testCustomMethods(){
//		createProduct();
//		Sort sort = Sort.by("title");
//		List<ProductsEntity> createdProduct = productsRepository.findByTitleContainsIgnoreCase("def");
//
//		System.out.println(createdProduct);
	}
}
