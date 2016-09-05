package jp.co.ananasgroup.repository;

import jp.co.ananasgroup.entity.Product;
import jp.co.ananasgroup.entity.ProductFilter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, Long> {

  List<Product> findByNameContainingIgnoreCase(String filterText);

//  List<Product> findByStockedIsTrue();

//  @Query("{ 'name' : { $regex: '.*?0.*', $options: 'i' }, 'stocked' : true }")
//  List<Product> filter(String filterText);

}
