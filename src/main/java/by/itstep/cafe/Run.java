package by.itstep.cafe;

import by.itstep.cafe.dao.entity.Cart;
import by.itstep.cafe.dao.repository.OrderDao;

public class Run {
    public static void main(String[] args) {

        OrderDao orderDao = null;

        Cart cart = new Cart();
        orderDao.save(cart);
    }
}