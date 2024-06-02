package Ecommerce.example.Ecommerce.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends  BaseModel{
    private String name;
    private String Description;
    @OneToMany(mappedBy = "category")
    private List<Products> products;
}
