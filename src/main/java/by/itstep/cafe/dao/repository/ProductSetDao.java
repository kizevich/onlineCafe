package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.ProductSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductSetDao extends JpaRepository<ProductSet, Integer> {

    List<ProductSet> findByCartId(int id);

    @Query(nativeQuery = true, value = "SELECT ps.quantity, ps.cartId, p.price\n" +
            "FROM productset ps\n" +
            "INNER JOIN product p ON ps.productId = p.id\n" +
            "WHERE cartId = : cartId")
    List<ProductSet> getProductSetsWithPrices(int cartId);
}
