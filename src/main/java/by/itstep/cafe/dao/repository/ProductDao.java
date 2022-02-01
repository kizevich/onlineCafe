package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductDao extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);

    List<Product> findAllById(List<Integer> ids);

}
