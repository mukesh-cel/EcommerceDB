package Ecommerce.example.Ecommerce.Repository;

import Ecommerce.example.Ecommerce.Models.Category;
import Ecommerce.example.Ecommerce.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findByname(String name);
    /*@Query(value="select * from ecommercedb.category where name =:name", nativeQuery = true)
    List<Category> findBynames(@Param("name") String name);*/
}
