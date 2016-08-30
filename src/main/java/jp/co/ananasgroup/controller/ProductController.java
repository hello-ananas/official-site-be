package jp.co.ananasgroup.controller;

import jp.co.ananasgroup.entity.Product;
import jp.co.ananasgroup.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController extends AbstractAPIController {

  @Autowired
  private ProductRepository productRepository;

  @RequestMapping(path = "/products", method = RequestMethod.GET)
  public List<Product> getAll() {
    return productRepository.findAll();
  }

  @RequestMapping(path = "/products/{filterText}", method = RequestMethod.GET)
  public List<Product> filter(@PathVariable String filterText) {
      return productRepository.findByProductName(filterText);
  }

}
