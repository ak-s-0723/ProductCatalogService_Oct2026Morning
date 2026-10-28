package org.example.productcatalogservice_oct2026morning.controllers;

import org.example.productcatalogservice_oct2026morning.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//singleton object -> bean
//container (spring context)  in which beans are stored

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Iphone 18");
        product.setDescription("Launched in 2026");
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }


    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long productId) {
        Product product = new Product();
        product.setId(productId);
        return product;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return product;
    }

//    @GetMapping("/products/{pid}/users/{uid}")
//    public Product getProductBasedOnUserAccess(@PathVariable("pid") Long productId,
//                                               @PathVariable("uid") Long userId) {}


}
