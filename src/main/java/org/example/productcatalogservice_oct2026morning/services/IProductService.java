package org.example.productcatalogservice_oct2026morning.services;

import org.example.productcatalogservice_oct2026morning.models.Product;

public interface IProductService {
    Product getProductById(Long id);

    Product replaceProduct(Long id, Product inputProduct);
}
