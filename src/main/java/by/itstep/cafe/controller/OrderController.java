package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface OrderController {

    Cart addOrder(Cart cart);

    void removeOrder(int id);

    public List findAllOrdersByUserName(String name);

    List<Cart> listOrders();

}
