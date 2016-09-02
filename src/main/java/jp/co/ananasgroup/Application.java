package jp.co.ananasgroup;

import jp.co.ananasgroup.entity.Product;
import jp.co.ananasgroup.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  private ProductRepository repoProduct;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurerAdapter() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowedOrigins("http://54.249.3.108:3001");
      }
    };
  }

  @Override
  public void run(String... args) throws Exception {
    this.initProduct();
  }

  private void initProduct() {
    this.repoProduct.deleteAll();

    this.repoProduct.save(new Product("1", "Sporting Goods", 49.99F, true, "Football"));
    this.repoProduct.save(new Product("2", "Sporting Goods", 9.99F, true, "Baseball"));
    this.repoProduct.save(new Product("3", "Sporting Goods", 29.99F, false, "Basketball"));
    this.repoProduct.save(new Product("4", "Electronics", 99.99F, true, "iPod Touch"));
    this.repoProduct.save(new Product("5", "Electronics", 399.99F, false, "iPhone 5"));
    this.repoProduct.save(new Product("6", "Electronics", 199.99F, true, "Nexus 7"));

    // fetch all customers
    System.out.println("Products found with findAll():");
    System.out.println("-------------------------------");
    this.repoProduct.findAll().stream().forEach((comment -> {
      System.out.println(comment);
    }));
  }
}
