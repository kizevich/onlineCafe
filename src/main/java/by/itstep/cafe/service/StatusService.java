package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.Status;

import java.util.List;
import java.util.Optional;

public interface StatusService {

    void save(Status status);

    void removeStatus(int id);

    List<Status> listStatuses();

    int getDiscountById(int id);

    Status findById(int id) throws Exception;

    Status getStatus(String name) throws Exception;

    Status findNextStatus(int discount) throws Exception;
}
