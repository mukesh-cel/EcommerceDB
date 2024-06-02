package Ecommerce.example.Ecommerce.DTO;

import Ecommerce.example.Ecommerce.Models.Category;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {
    private UUID uuid;
    private String name;
    private Double price;
    private String Description;
    private Category category;
    private String categoryname;
    private String image;
}
