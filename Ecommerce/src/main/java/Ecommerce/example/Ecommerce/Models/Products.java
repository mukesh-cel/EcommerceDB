package Ecommerce.example.Ecommerce.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Products extends BaseModel{
    private String name;
    private Double price;
    private String Description;
    @ManyToOne
    private Category category;
    private String image;

}
