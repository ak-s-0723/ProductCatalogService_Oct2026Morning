package org.example.productcatalogservice_oct2026morning.controllers;

import org.example.productcatalogservice_oct2026morning.dtos.CategoryDto;
import org.example.productcatalogservice_oct2026morning.dtos.ProductDto;
import org.example.productcatalogservice_oct2026morning.models.Product;
import org.example.productcatalogservice_oct2026morning.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//singleton object -> bean
//container (spring context)  in which beans are stored

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
//        Product product = new Product();
//        product.setId(1L);
//        product.setName("Iphone 18");
//        product.setDescription("Launched in 2026");
//        List<Product> products = new ArrayList<>();
//        products.add(product);
//        return products;
        return null;
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
       Product product = productService.getProductById(productId);
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("called by","anurag khanna");

       if (product == null) {
           return new ResponseEntity<>(null,headers,HttpStatus.NOT_FOUND);
       }

       ProductDto productDto = from(product);
       return new ResponseEntity<>(productDto, headers, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setId(product.getId());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setDescription(product.getCategory().getDescription());
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            productDto.setCategory(categoryDto);
        }

        return productDto;
    }

//    @GetMapping("/products/{pid}/users/{uid}")
//    public Product getProductBasedOnUserAccess(@PathVariable("pid") Long productId,
//                                               @PathVariable("uid") Long userId) {}


}
