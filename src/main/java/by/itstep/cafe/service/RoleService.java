package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.Role;

import java.util.List;

public interface RoleService {

    Role addRole(Role role);

    void removeRole(int id);

    List listRoles();

    Role getRole(String name);

}
