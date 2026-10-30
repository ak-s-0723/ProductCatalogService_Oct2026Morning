package org.example.productcatalogservice_oct2026morning.services;

import org.example.productcatalogservice_oct2026morning.dtos.FakeStoreProductDto;
import org.example.productcatalogservice_oct2026morning.models.Category;
import org.example.productcatalogservice_oct2026morning.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService implements IProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public Product getProductById(Long id) {
        //Calling FakeStore Endpoint
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto  = restTemplate.getForObject
                ("https://fakestoreapi.com/products/{id}",
                                  FakeStoreProductDto.class,id);

        return from(fakeStoreProductDto);
    }

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return  product;
    }
}
