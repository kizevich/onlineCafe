package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.Status;

import java.util.List;
import java.util.Optional;

public interface StatusService {

    void save(Status status);

    void removeStatus(int id);

    List listStatuses();

    int getDiscountById(int id);

    Status findById(int id);

    Status getStatus(String name);

    Optional<Status> findNextStatus(int discount);
}
