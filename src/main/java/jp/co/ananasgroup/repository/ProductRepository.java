package jp.co.ananasgroup.repository;

import jp.co.ananasgroup.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, Long> {

  @Query("{ 'name' : { $regex: '.*?0.*' } }")
  List<Product> findByProductName(String name);

}
