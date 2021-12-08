package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.OrderController;
import by.itstep.cafe.dao.entity.Order;
import by.itstep.cafe.service.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderControllerImpl implements OrderController {

    private OrderService orderService;

    public OrderControllerImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Order addOrder(Order order) {
        return orderService.addOrder(order);
    }

    @Override
    public void removeOrder(int id) {
        orderService.removeOrder(id);
    }

    @Override
    public List<Order> listOrders() {
        return orderService.listOrders();
    }

    @Override
    public Optional<Order> getOrder(int id) {
        return orderService.getOrder(id);
    }
}
