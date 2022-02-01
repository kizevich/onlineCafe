package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.repository.StatusDao;
import by.itstep.cafe.dao.entity.Status;
import by.itstep.cafe.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusDao statusDao;

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
    public List<Status> listStatuses() {
        return statusDao.findAll();
    }

    @Override
    public int getDiscountById(int id) {
        return statusDao.getDiscountById(id);
    }

    @Override
    public Status findById(int id) throws Exception {
        Optional<Status> optionalStatus = statusDao.findById(id);

        if (optionalStatus.isPresent()){

            return optionalStatus.get();
        } else {
            throw new Exception("status is not exist");
        }
    }

    @Override
    public Status getStatus(String name) throws Exception {
        Optional<Status> optionalStatus = statusDao.findByName(name);

        if (optionalStatus.isPresent()){

            return optionalStatus.get();
        } else {
            throw new Exception("status is not exist");
        }
    }

    @Override
    public Status findNextStatus(int discount) throws Exception {
        Optional<Status> optionalStatus = statusDao.findNextStatus(discount);

        if (optionalStatus.isPresent()){

            return optionalStatus.get();
        } else {
            throw new Exception("status is not exist");
        }
    }
}
