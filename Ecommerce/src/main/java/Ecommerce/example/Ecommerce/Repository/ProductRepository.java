package Ecommerce.example.Ecommerce.Repository;

import Ecommerce.example.Ecommerce.Models.Category;
import Ecommerce.example.Ecommerce.Models.Products;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Products, UUID> {
    /*select id, description, image ,name, price,category_id " +
            "from products where (select id from category where name =:name*/
    @Query(value="select BIN_TO_UUID(p.id), p.description, p.image ,p.name, p.price from products p  left join category c " +
            "on p.category_id=c.id and c.name=:name where p.id is not null", nativeQuery = true)
    List<Products> findBynames(@Param("name") String name);

    Products findByname(String name);
    @Modifying
    @Query(value = "delete from products as p where p.name= ?1",nativeQuery = true)
    void deletbyname( String name);

    @Query(value = "select * from products order by price ?1",nativeQuery = true)
    List<Products> findyid(String dir);
}
