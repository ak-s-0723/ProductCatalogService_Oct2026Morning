package org.example.productcatalogservice_oct2026morning.repos;

import org.example.productcatalogservice_oct2026morning.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
