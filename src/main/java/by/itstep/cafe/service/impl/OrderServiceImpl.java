package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.dao.repository.OrderDao;
import by.itstep.cafe.dao.entity.Order;
import by.itstep.cafe.service.OrderService;
import by.itstep.cafe.service.StatusService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public Order save(Order order) {
//        User client = order.getClient();
//        BigDecimal discount = BigDecimal.valueOf(client.getStatus().getDiscount());
//        order.setFullPrice(order.getFullPrice().subtract((order.getFullPrice().multiply(discount)).multiply(BigDecimal.valueOf(0.01))));
//        if (statusService.findNextStatus(client.getStatus().getDiscount()).isPresent()) {
//            client.setStatus(statusService.findNextStatus(client.getStatus().getDiscount()).get());
//        }
//        if (client.getDateOfBirth().equals(order.getCreateDate())) {
//            order.setFullPrice((order.getFullPrice().subtract(order.getFullPrice().multiply(BigDecimal.valueOf(0.9)))));
//        }
        return orderDao.save(order);
    }

    @Override
    public List<Order> findAllOrdersByUserName(String name) {
        return orderDao.findAllByClient_UserName(name);
    }

    @Override
    public List<Order> findAllOrderByDate(LocalDateTime date) {
        return orderDao.findAllByCreateDate(date);
    }

    @Override
    public void removeOrder(int id) {
        orderDao.deleteById(id);
    }

    @Override
    public List<Order> listOrders() {
        return orderDao.findAll();
    }

    @Override
    public Optional<Order> getOrder(int id) {
        return orderDao.findById(id);
    }

    @Override
    public List<Order> getOrdersByDate(LocalDateTime date) {
        return orderDao.findAllByCreateDate(date);
    }
}
