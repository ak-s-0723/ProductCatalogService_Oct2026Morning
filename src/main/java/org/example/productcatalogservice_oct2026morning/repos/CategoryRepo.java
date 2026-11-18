package org.example.productcatalogservice_oct2026morning.repos;

import org.example.productcatalogservice_oct2026morning.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepo extends JpaRepository<Category,Long> {

    @Query("SELECT c.name from Category  c where c.id=?1")
    //@Query("SELECT c.name from Category  c where c.id=:id")
    String getCategoryTitleById(Long id);
}


//int add(int a, String b, Boolean c) {
//
//}
//
//add(1,"Anurag",0); //positional
//add(b="anurag", a=1, c=0)  //named


