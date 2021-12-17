package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.dao.repository.OrderDao;
import by.itstep.cafe.dao.entity.Order;
import by.itstep.cafe.service.OrderService;
import by.itstep.cafe.service.StatusService;
import org.springframework.stereotype.Service;

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
    public Order addOrder(Order order) {
        User client = order.getClient();
        int discount = client.getStatus().getDiscount();
        // TODO big decimal
        order.setFullPrice((int) (order.getFullPrice() - order.getFullPrice() * 0.01 * discount));
        if (statusService.findNextStatus(client.getStatus().getDiscount()).isPresent()) {
            client.setStatus(statusService.findNextStatus(client.getStatus().getDiscount()).get());
        }
        if (client.getDateOfBirth().equals(order.getCreateDate())) {
            order.setFullPrice((int) (order.getFullPrice() - order.getFullPrice() * 0.9));
        }
        return orderDao.save(order);
    }

    @Override
    public List<Order> findAllOrdersByUserName(String name) {
        return orderDao.findAllByClient_UserName(name);
    }

    @Override
    public List<Order> findAllOrderByDate(String date) {
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
    public List<Order> getOrdersByDate(String date) {
        return orderDao.findAllByCreateDate(date);
    }
}
