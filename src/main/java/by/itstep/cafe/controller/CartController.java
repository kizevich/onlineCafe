package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.Cart;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

public interface CartController {

    Cart addOrder(Cart cart);

    void removeOrder(int id);

    public List findAllOrdersByUserName(String name);

    List<Cart> listOrders();

    void confirmCart(String id, Model model) throws Exception;
}
