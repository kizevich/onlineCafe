package by.itstep.cafe.dao.repository;

import by.itstep.cafe.dao.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface OrderDao extends JpaRepository<Order, Integer> {

    List<Order> findAllByCreateDate(LocalDateTime date);

    List<Order> findAllByClient_UserName(String name);
}
