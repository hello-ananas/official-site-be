package jp.co.ananasgroup.repository;

import jp.co.ananasgroup.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long> {

}
