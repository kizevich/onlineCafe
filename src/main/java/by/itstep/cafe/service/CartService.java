package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.Cart;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CartService {

    Cart save(Cart cart);

    void removeOrder(int id);

    List<Cart> listOrders();

    public List<Cart> findAllOrdersByUserName(String name);

    public List<Cart> findAllOrderByDate(LocalDateTime date);

    Cart getOrder(int id) throws Exception;

    List<Cart> getOrdersByDate(LocalDateTime date);

    Cart getByState(String state) throws Exception;

    Cart confirmCart(Cart cart);

    Cart getById(int id) throws Exception;
}
