package org.example.productcatalogservice_oct2026morning.services;

import org.example.productcatalogservice_oct2026morning.models.Product;
import org.example.productcatalogservice_oct2026morning.models.State;
import org.example.productcatalogservice_oct2026morning.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isEmpty()) {
            return null;
        }

        return optionalProduct.get();
    }

    @Override
    public Product replaceProduct(Long id, Product inputProduct) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new RuntimeException("Product with id "+ id+" doesn't exist");
        } else {
            inputProduct.setId(id);  //explicitly setting it
            return productRepo.save(inputProduct);
        }
    }

    @Override
    public Product addProduct(Product product) {
        Optional<Product> optionalProduct = productRepo.findById(product.getId());
        if(optionalProduct.isEmpty()) {
            return productRepo.save(product);
        } else {
            throw new RuntimeException("Product with id "+ product.getId() + "already exist");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public void deleteProductById(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            if(product.getState().equals(State.ACTIVE)) {
                product.setState(State.DELETED);
                productRepo.save(product);
            } else {
                productRepo.deleteById(id);
            }
        } else {
           throw new RuntimeException("Product with id"+id+" doesn't exist");
        }
    }
}
