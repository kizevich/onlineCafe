package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.entity.Cart;
import by.itstep.cafe.dao.entity.Product;
import by.itstep.cafe.dao.entity.ProductSet;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.dao.repository.CartDao;
import by.itstep.cafe.service.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CartServiceImpl implements CartService {

    private static final String CLOSED = "Closed";
    private final CartDao cartDao;
    private final StatusService statusService;
    private final UserService userService;
    private final ProductSetService productSetService;
    private final ProductService productService;

    public CartServiceImpl(CartDao cartDao, StatusService statusService, UserService userService, ProductSetService productSetService, ProductService productService) {
        this.cartDao = cartDao;
        this.statusService = statusService;
        this.userService = userService;
        this.productSetService = productSetService;
        this.productService = productService;
    }

    @Override
    public Cart save(Cart cart) {
//        User client = order.getClient();
//        BigDecimal discount = BigDecimal.valueOf(client.getStatus().getDiscount());
//        order.setFullPrice(order.getFullPrice().subtract((order.getFullPrice().multiply(discount)).multiply(BigDecimal.valueOf(0.01))));
//        if (statusService.findNextStatus(client.getStatus().getDiscount()).isPresent()) {
//            client.setStatus(statusService.findNextStatus(client.getStatus().getDiscount()).get());
//        }
//        if (client.getDateOfBirth().equals(order.getCreateDate())) {
//            order.setFullPrice((order.getFullPrice().subtract(order.getFullPrice().multiply(BigDecimal.valueOf(0.9)))));
//        }
        return cartDao.save(cart);
    }

    @Override
    public List<Cart> findAllOrdersByUserName(String name) {
        return cartDao.findAllByClient_UserName(name);
    }

    @Override
    public List<Cart> findAllOrderByDate(LocalDateTime date) {
        return cartDao.findAllByCreateDate(date);
    }

    @Override
    public void removeOrder(int id) {
        cartDao.deleteById(id);
    }

    @Override
    public List<Cart> listOrders() {
        return cartDao.findAll();
    }

    @Override
    public Cart getOrder(int id) throws Exception {
        Optional<Cart> optionalOrder = cartDao.findById(id);

        if (optionalOrder.isPresent()){

            return optionalOrder.get();

        } else {
            throw new Exception("cart is not exist");
        }
    }

    @Override
    public List<Cart> getOrdersByDate(LocalDateTime date) {
        return cartDao.findAllByCreateDate(date);
    }

    @Override
    public Cart getByState(String state) throws Exception {
        Optional<Cart> optionalOrder = cartDao.findByState(state);

        if (optionalOrder.isPresent()){

            return optionalOrder.get();
        } else {
            throw new Exception("cart is not exist");
        }
    }

    @Override
    public Cart confirmCart(Cart cart) throws Exception {
        cart.setState(CLOSED);
        calculatePrice(cart);
        return null;
    }

    @Override
    public Cart getById(int id) throws Exception {
        Optional<Cart> optionalOrder = cartDao.findById(id);

        if (optionalOrder.isPresent()){

            return optionalOrder.get();
        } else {
            throw new Exception("cart is not exist");
        }
    }

    private void calculatePrice(Cart cart) throws Exception {
        User client = cart.getClient();
        BigDecimal fullPrice = BigDecimal.ZERO;
        BigDecimal discount = BigDecimal.valueOf(userService.getDiscountByUserId(client.getId()));
        List<ProductSet> productSets = productSetService.getProductSetsWithPrice(cart.getId());

        for(ProductSet productSet : productSets) {
            fullPrice = fullPrice.add(productSet.getProduct().getPrice().multiply(BigDecimal.valueOf(productSet.getAmount())));
        }

        fullPrice = fullPrice.multiply(discount.divide(BigDecimal.valueOf(100)));
        cart.setFullPrice(fullPrice);
    }
}
