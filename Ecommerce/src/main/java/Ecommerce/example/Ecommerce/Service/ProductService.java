package Ecommerce.example.Ecommerce.Service;

import Ecommerce.example.Ecommerce.DTO.CategoryResponseDTO;
import Ecommerce.example.Ecommerce.DTO.ProductResponseDTO;
import Ecommerce.example.Ecommerce.Models.Category;
import Ecommerce.example.Ecommerce.Models.Products;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface ProductService {
    public ProductResponseDTO addprodcuts(String categoryname, Products products);
    public List<ProductResponseDTO> productsinspecificcategory(String name);
    public List<ProductResponseDTO> getallproducts();
    public ProductResponseDTO updateproductbyname( String productname, Products products);
    public void deleteproductbyname( String name);
    ProductResponseDTO getproductbyname(String name);
    public List<ProductResponseDTO> sortbyfield( String feild);
    public List<ProductResponseDTO> pagination( int offset, int pagesize);
    public List<ProductResponseDTO> paginationandsorting(int offset, int pagesize);

}
