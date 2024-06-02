package Ecommerce.example.Ecommerce.Controllers;

import Ecommerce.example.Ecommerce.DTO.CategoryResponseDTO;
import Ecommerce.example.Ecommerce.Models.Category;
import Ecommerce.example.Ecommerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    private CategoryService categoryService;
    @Autowired
    public CategoryController (CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @PostMapping("/create")
    public CategoryResponseDTO createcategories(@RequestBody Category category){
        return categoryService.createcategories(category);
    }

    @GetMapping("/listallcategories")
    public List<String> listallcategories(){
        return categoryService.listallcategories();
    }

}
