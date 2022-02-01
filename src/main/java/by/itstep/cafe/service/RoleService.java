package by.itstep.cafe.service;

import by.itstep.cafe.dao.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Role save(Role role);

    void removeRole(int id);

    List<Role> listRoles();

    Role getRole(String name) throws Exception;

    Role findById(int id) throws Exception;

}
