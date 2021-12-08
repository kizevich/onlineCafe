package by.itstep.cafe.controller;

import by.itstep.cafe.dao.entity.Role;

import java.util.List;

public interface RoleController {

    Role addRole(Role role);

    void removeRole(int id);

    List listRoles();

    Role getRole(String name);
}
