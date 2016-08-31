package jp.co.ananasgroup.controller;

import com.google.common.base.Strings;
import jp.co.ananasgroup.entity.Product;
import jp.co.ananasgroup.entity.ProductFilter;
import jp.co.ananasgroup.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

  @RequestMapping(path = "/products", method = RequestMethod.POST)
  public List<Product> filter(@RequestBody ProductFilter filter) {
    if (!Strings.isNullOrEmpty(filter.getFilterText())) {
      if (filter.isInStockOnly()) {
        return productRepository.filter(filter.getFilterText());
      } else {
        return productRepository.findByNameContainingIgnoreCase(filter.getFilterText());
      }
    } else {
      if (filter.isInStockOnly()) {
        return productRepository.findByStockedIsTrue();
      }
    }
    return productRepository.findAll();
  }
}
