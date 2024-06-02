package Ecommerce.example.Ecommerce;

import Ecommerce.example.Ecommerce.Models.Category;
import Ecommerce.example.Ecommerce.Models.Products;
import Ecommerce.example.Ecommerce.Repository.CategoryRepository;
import Ecommerce.example.Ecommerce.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class EcommerceApplication  {

	/*private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	public EcommerceApplication(ProductRepository productRepository, CategoryRepository categoryRepository){
		this.productRepository=productRepository;
		this.categoryRepository=categoryRepository;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	//@Override
	//public void run(String... args) throws Exception {

		/*Category category= new Category();
		category.setName("Mobiles");
		category.setDescription("Mobile Phone Category");
		Category savedactegory = categoryRepository.save(category);

		//List<Products> products= new ArrayList<>();
		for (int i=0;i<6;i++){
			Products products1= new Products();
			products1.setName("Iphone "+ (7+i));
			products1.setPrice(100000.0 + i*10000);
			products1.setCategory(savedactegory);
			products1.setImage("https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-13-01.jpg");
			products1.setDescription("Iphone Model best in market and best in use");
			productRepository.save(products1);
		}*/

		/*Optional<Category> categoryOptional= categoryRepository.
				findById(UUID.fromString("5bcc8464-c565-47d7-8ef5-9f827d1ba7dc"));
		if(!categoryOptional.isEmpty()){
			System.out.println(categoryOptional.get().getName());
			System.out.println(categoryOptional.get().getDescription());

		}*/
	//}
}
