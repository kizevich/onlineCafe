package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.Status;

import java.util.List;
import java.util.Optional;

public interface StatusService {

    void addStatus(Status status);

    void removeStatus(int id);

    List listStatuses();

    Status getStatus(String name);

    Optional<Status> findNextStatus(int discount);
}
