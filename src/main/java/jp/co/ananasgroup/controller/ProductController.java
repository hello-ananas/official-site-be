package jp.co.ananasgroup.controller;

import jp.co.ananasgroup.entity.Product;
import jp.co.ananasgroup.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @CrossOrigin(origins = "http://localhost:3001") // https://spring.io/guides/gs/rest-service-cors/
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> get() {
        return productRepository.findAll();
    }

}
