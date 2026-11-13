package org.example.productcatalogservice_oct2026morning.services;

import org.example.productcatalogservice_oct2026morning.models.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id);

    Product replaceProduct(Long id, Product inputProduct);
    
    Product addProduct(Product product);
    
    List<Product> getAllProducts();

    void deleteProductById(Long id);
}
