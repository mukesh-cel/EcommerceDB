package Ecommerce.example.Ecommerce.Service;

import Ecommerce.example.Ecommerce.DTO.ProductResponseDTO;
import Ecommerce.example.Ecommerce.Models.Category;
import Ecommerce.example.Ecommerce.Models.Products;
import Ecommerce.example.Ecommerce.Repository.CategoryRepository;
import Ecommerce.example.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductserviceDB implements ProductService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    @Autowired
    public ProductserviceDB(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public ProductResponseDTO addprodcuts(String name, Products products) {
        ProductResponseDTO productResponseDTO= new ProductResponseDTO();
        Category category= categoryRepository.findByname(name);
        products.setCategory(category);
        productRepository.save(products);

        productResponseDTO.setUuid(products.getUuid());
        productResponseDTO.setName(products.getName());
        productResponseDTO.setCategoryname(products.getCategory().getName());
        //productResponseDTO.setCategory(categoryRepository.findByname(name));
        productResponseDTO.setPrice(products.getPrice());
        productResponseDTO.setImage(products.getImage());
        productResponseDTO.setDescription(products.getDescription());

        return productResponseDTO;
    }
    public List<ProductResponseDTO> productsinspecificcategory(String name){
        List<Products> productsList= productRepository.findBynames(name);
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();

            for(Products p : productsList) {
                ProductResponseDTO productResponseDTO = new ProductResponseDTO();
                productResponseDTO.setUuid(p.getUuid());
                productResponseDTO.setName(p.getName());
                //productResponseDTO.setPrice(p.getPrice());
                //productResponseDTO.setCategory(p.getCategory());
                //productResponseDTO.setImage(p.getImage());
                //productResponseDTO.setDescription(p.getDescription());

                productResponseDTOs.add(productResponseDTO);
            }

        System.out.println(productResponseDTOs.size());
        return productResponseDTOs;
    }

    @Override
    public List<ProductResponseDTO> getallproducts() {
        List<Products> productsList= productRepository.findAll();

        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Products p: productsList){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setUuid(p.getUuid());
            productResponseDTO.setName(p.getName());
            productResponseDTO.setPrice(p.getPrice());
            productResponseDTO.setImage(p.getImage());
            productResponseDTO.setDescription(p.getDescription());
            productResponseDTO.setCategoryname(p.getCategory().getName());
            Category category= categoryRepository.findByname(p.getName());
            productResponseDTO.setCategory(category);

            productResponseDTOS.add(productResponseDTO);
        }
        //System.out.println("products size:" + productResponseDTOS.size());
        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO updateproductbyname(String productname, Products products) {
        Products savedproduct= productRepository.findByname(productname);
        if(products.getName()!=null) {
            savedproduct.setName(products.getName());
        }
        if(products.getPrice()!=null) {
            savedproduct.setPrice(products.getPrice());
        }
        if(products.getImage()!=null) {
            savedproduct.setImage(products.getImage());
        }
        if(products.getDescription()!=null) {
            savedproduct.setDescription(products.getDescription());
        }

        Products updatedproduct = productRepository.save(savedproduct);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setUuid(updatedproduct.getUuid());
        productResponseDTO.setName(updatedproduct.getName());
        productResponseDTO.setCategoryname(updatedproduct.getCategory().getName());
        productResponseDTO.setPrice(updatedproduct.getPrice());
        productResponseDTO.setImage(updatedproduct.getImage());
        productResponseDTO.setDescription(updatedproduct.getDescription());
        return productResponseDTO;
    }

    @Override
    public void deleteproductbyname(String name) {
         productRepository.deletbyname(name);
    }

    @Override
    public ProductResponseDTO getproductbyname(String name) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        Products products=productRepository.findByname(name);
        if(products!=null) {
            productResponseDTO.setUuid(products.getUuid());
            productResponseDTO.setName(products.getName());
            productResponseDTO.setCategoryname(products.getCategory().getName());
            productResponseDTO.setPrice(products.getPrice());
            productResponseDTO.setImage(products.getImage());
            productResponseDTO.setDescription(products.getDescription());
        }
        else {
            throw new RuntimeException("Please specify correct product name");
        }
        return productResponseDTO;
    }

    @Override
    public List<ProductResponseDTO> sortbyfield(String feild) {
        List<Products> productsList=  productRepository.findAll(Sort.by(Sort.Direction.ASC, feild));
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Products p: productsList){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setUuid(p.getUuid());
            productResponseDTO.setName(p.getName());
            productResponseDTO.setPrice(p.getPrice());
            productResponseDTO.setImage(p.getImage());
            productResponseDTO.setDescription(p.getDescription());
            productResponseDTO.setCategoryname(p.getCategory().getName());
            //Category category= categoryRepository.findByname(p.getName());
            //productResponseDTO.setCategory(category);

            productResponseDTOS.add(productResponseDTO);
        }
        //System.out.println("products size:" + productResponseDTOS.size());
        return productResponseDTOS;
    }

    @Override
    public List<ProductResponseDTO> pagination(int offset, int pagesize) {
        Page<Products> productsPage= productRepository.findAll(PageRequest.of(offset,pagesize));
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Products p: productsPage){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setUuid(p.getUuid());
            productResponseDTO.setName(p.getName());
            productResponseDTO.setPrice(p.getPrice());
            productResponseDTO.setImage(p.getImage());
            productResponseDTO.setDescription(p.getDescription());
            productResponseDTO.setCategoryname(p.getCategory().getName());
            //Category category= categoryRepository.findByname(p.getName());
            //productResponseDTO.setCategory(category);

            productResponseDTOS.add(productResponseDTO);
        }
        //System.out.println("products size:" + productResponseDTOS.size());
        return productResponseDTOS;
    }

    @Override
    public List<ProductResponseDTO> paginationandsorting(int offset, int pagesize) {
        return null;
        //return productRepository.findAll(PageRequest.of(offset,pagesize,Sort.by(Sort.Direction.DESC,feild)));;
    }

    /*public List<ProductResponseDTO> paginationandsorting(int offset, int pagesize, String feild){
        return productRepository.findAll(PageRequest.of(offset,pagesize,Sort.by(Sort.Direction.DESC,feild)));
    }*/
}
