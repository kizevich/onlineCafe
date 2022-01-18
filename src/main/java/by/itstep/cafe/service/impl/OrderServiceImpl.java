package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.entity.Cart;
import by.itstep.cafe.dao.repository.OrderDao;
import by.itstep.cafe.service.OrderService;
import by.itstep.cafe.service.StatusService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private StatusService statusService;

    public OrderServiceImpl (OrderDao orderDao, StatusService statusService) {
        this.orderDao = orderDao;
        this.statusService = statusService;
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
        return orderDao.save(cart);
    }

    @Override
    public List<Cart> findAllOrdersByUserName(String name) {
        return orderDao.findAllByClient_UserName(name);
    }

    @Override
    public List<Cart> findAllOrderByDate(LocalDateTime date) {
        return orderDao.findAllByCreateDate(date);
    }

    @Override
    public void removeOrder(int id) {
        orderDao.deleteById(id);
    }

    @Override
    public List<Cart> listOrders() {
        return orderDao.findAll();
    }

    @Override
    public Cart getOrder(int id) throws Exception {
        Optional<Cart> optionalOrder = orderDao.findById(id);

        if (optionalOrder.isPresent()){
            Cart cart = optionalOrder.get();

            return cart;

        } else {
            throw new Exception("order is not exist");
        }
    }

    @Override
    public List<Cart> getOrdersByDate(LocalDateTime date) {
        return orderDao.findAllByCreateDate(date);
    }

    @Override
    public Cart getByState(String state) throws Exception {
        Optional<Cart> optionalOrder = orderDao.findByState(state);

        if (optionalOrder.isPresent()){
            Cart cart = optionalOrder.get();

            return cart;
        } else {
            throw new Exception("order is not exist");
        }
    }
}
