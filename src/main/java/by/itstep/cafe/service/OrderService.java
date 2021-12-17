package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order addOrder(Order order);

    void removeOrder(int id);

    List<Order> listOrders();

    public List<Order> findAllOrdersByUserName(String name);

    public List<Order> findAllOrderByDate(String date);

    Optional<Order> getOrder(int id);

    List<Order> getOrdersByDate(String date);
}
