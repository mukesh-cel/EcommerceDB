package Ecommerce.example.Ecommerce.DTO;

import Ecommerce.example.Ecommerce.Models.Products;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryResponseDTO {
    private UUID uuid;
    private String name;
    private String Description;

    private List<Products> products;

}
