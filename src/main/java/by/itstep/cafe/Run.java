package by.itstep.cafe;

import by.itstep.cafe.dao.entity.Cart;
import by.itstep.cafe.dao.repository.CartDao;

public class Run {
    public static void main(String[] args) {

        CartDao cartDao = null;

        Cart cart = new Cart();
        cartDao.save(cart);
    }
}