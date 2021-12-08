package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDao extends JpaRepository<Product, Integer> {

    Product findByName(String name);

}
