package Ecommerce.example.Ecommerce.Controllers;


import Ecommerce.example.Ecommerce.DTO.CategoryResponseDTO;
import Ecommerce.example.Ecommerce.DTO.ProductResponseDTO;
import Ecommerce.example.Ecommerce.Models.Category;
import Ecommerce.example.Ecommerce.Models.Products;
import Ecommerce.example.Ecommerce.Service.CategoryService;
import Ecommerce.example.Ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;
    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService){
        this.productService=productService;
        this.categoryService=categoryService;
    }
    @PostMapping("/addproduct/{category}")
    public ProductResponseDTO addprodcuts(@PathVariable("category") String name, @RequestBody Products products){
        return  productService.addprodcuts(name,products);
    }
    @GetMapping("/category/{category}")
    public List<ProductResponseDTO> productsinspecificcategory(@PathVariable("category") String name){
        return  productService.productsinspecificcategory(name);
    }
    @GetMapping("/allproducts")
    public List<ProductResponseDTO> getallproducts(){
        return productService.getallproducts();
    }
    @PostMapping("/updateProducts/{productname}")
    public ProductResponseDTO updateproductbyname(@PathVariable("productname") String productname, @RequestBody Products products){
        return productService.updateproductbyname(productname,products);
    }
    @DeleteMapping("/deleteproduct/{name}")
    public void deleteproductbyname(@PathVariable("name") String name ){
         productService.deleteproductbyname(name);
    }
    @GetMapping("/{name}")
    public ProductResponseDTO getproductbyname(@PathVariable("name") String name){
        return productService.getproductbyname(name);
    }

    @GetMapping("/sort/{field}")
    public List<ProductResponseDTO> sortbyfield(@PathVariable("field") String feild){
        return  productService.sortbyfield(feild);
    }

    @GetMapping("/pagination/{offset}/{size}")
    public List<ProductResponseDTO> sortbyfield(@PathVariable("offset") int offset, @PathVariable("size") int size){
        return  productService.pagination(offset, size);
    }
}
