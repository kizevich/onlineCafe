package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.repository.StatusDao;
import by.itstep.cafe.dao.entity.Status;
import by.itstep.cafe.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusDao statusDao;

    public StatusServiceImpl(StatusDao statusDao) {
        this.statusDao = statusDao;
    }

    @Override
    public void save(Status status) {
        statusDao.save(status);
    }

    @Override
    public void removeStatus(int id) {
        statusDao.deleteById(id);
    }

    @Override
    public List listStatuses() {
        return statusDao.findAll();
    }

    @Override
    public int getDiscountById(int id) {
        return statusDao.getDiscountById(id);
    }

    @Override
    public Status findById(int id) {
        return statusDao.findById(id).get();
    }

    @Override
    public Status getStatus(String name) {
        return statusDao.findByName(name);
    }

    @Override
    public Optional<Status> findNextStatus(int discount) {
        return statusDao.findNextStatus(discount);
    }
}
