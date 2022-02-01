package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface CartDao extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByCreateDate(LocalDateTime date);

    List<Cart> findAllByClient_UserName(String name);

    Optional<Cart> findByState(String state);
}
