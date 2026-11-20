package org.example.productcatalogservice_oct2026morning.controllers;

import org.example.productcatalogservice_oct2026morning.dtos.ProductDto;
import org.example.productcatalogservice_oct2026morning.models.Product;
import org.example.productcatalogservice_oct2026morning.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private IProductService productService;

    @Test
    public void TestGetProductById_WithValidProductId_ReturnsProductSuccessfully() {
        //Arrange
        Long productId = 2L;

        Product product = new Product();
        product.setId(productId);
        product.setName("Iphone");
        when(productService.getProductById(productId)).thenReturn(product);

        //Act
        ResponseEntity<ProductDto> productDtoResponseEntity = productController.getProductById(productId);

        //Assert
        assertNotNull(productDtoResponseEntity);
        assertNotNull(productDtoResponseEntity.getBody());
        assertEquals(HttpStatus.OK, productDtoResponseEntity.getStatusCode());
        assertEquals(productId, productDtoResponseEntity.getBody().getId());
        assertEquals("Iphone", productDtoResponseEntity.getBody().getName());
    }


    @Test
    public void TestGetProductById_WithNegativeProductId_ResultsInIllegalArgumentException() {
        //Arrange
        Long productId = -5L;

        //Act and Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                ()-> productController.getProductById(productId));

        assertEquals("Invalid ProductId", exception.getMessage());
    }

    @Test
    public void TestGetProductById_WithNotAvailableProductId_ResultsInRuntimeException() {
        //Act and Assert
        assertThrows(RuntimeException.class,
                () -> productController.getProductById(10L));
    }

}