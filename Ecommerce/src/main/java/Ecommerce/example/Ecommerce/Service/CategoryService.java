package Ecommerce.example.Ecommerce.Service;

import Ecommerce.example.Ecommerce.DTO.CategoryResponseDTO;
import Ecommerce.example.Ecommerce.Models.Category;
import Ecommerce.example.Ecommerce.Models.Products;
import Ecommerce.example.Ecommerce.Repository.CategoryRepository;
import Ecommerce.example.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository,ProductRepository productRepository){
        this.categoryRepository=categoryRepository;
        this.productRepository=productRepository;
    }
    public CategoryResponseDTO createcategories(Category category){
        categoryRepository.save(category);
        CategoryResponseDTO categoryResponseDTO= new CategoryResponseDTO();
        categoryResponseDTO.setName(category.getName());
        categoryResponseDTO.setDescription(category.getDescription());
        categoryResponseDTO.setProducts(category.getProducts());
        return categoryResponseDTO;
    }

    public List<String> listallcategories(){
        List<Category> categories= categoryRepository.findAll();
        List<String> categoryResponseDTOS= new ArrayList<>();
        for(Category c: categories){
            CategoryResponseDTO categoryResponseDTO= new CategoryResponseDTO();
            categoryResponseDTOS.add(c.getName());
        }
        return categoryResponseDTOS;
    }


}
