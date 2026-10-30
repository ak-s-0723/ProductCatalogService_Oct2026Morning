package org.example.productcatalogservice_oct2026morning.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private String image;
}
