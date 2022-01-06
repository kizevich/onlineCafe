package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.ProductSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSetDao extends JpaRepository<ProductSet, Integer> {

    ProductSet findByOrderId(int id);
}
