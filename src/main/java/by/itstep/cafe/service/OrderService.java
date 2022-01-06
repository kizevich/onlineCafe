package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order save(Order order);

    void removeOrder(int id);

    List<Order> listOrders();

    public List<Order> findAllOrdersByUserName(String name);

    public List<Order> findAllOrderByDate(LocalDateTime date);

    Optional<Order> getOrder(int id);

    List<Order> getOrdersByDate(LocalDateTime date);
}
