package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.Status;

import java.util.List;

public interface StatusController {

    void addStatus(Status status);

    void removeStatus(int id);

    List listStatuses();

    Status getStatus(String name);
}
