package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderController {

    Order addOrder(Order order);

    void removeOrder(int id);

    List<Order> listOrders();

    Optional<Order> getOrder(int id);
}
