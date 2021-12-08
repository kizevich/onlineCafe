package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.RoleController;
import by.itstep.cafe.dao.entity.Role;
import by.itstep.cafe.service.RoleService;

import java.util.List;

public class RoleControllerImpl implements RoleController {

    private RoleService roleService;

    public RoleControllerImpl(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public Role addRole(Role role) {
        return roleService.addRole(role);
    }

    @Override
    public void removeRole(int id) {
        roleService.removeRole(id);
    }

    @Override
    public List listRoles() {
        return roleService.listRoles();
    }

    @Override
    public Role getRole(String name) {
        return roleService.getRole(name);
    }
}
