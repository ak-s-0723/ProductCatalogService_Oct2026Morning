package org.example.productcatalogservice_oct2026morning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel {
    private String name;

    private String description;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 3)
    private List<Product> products;
}

//1 + 5 (product)
//
//batchsize = 3
// 2 batches for product + 1 for category
//
//batchsize = 2
//3 batch queries for product + 1 for category
//
//batchsize  = 5
//1 batch query + 1 category query
