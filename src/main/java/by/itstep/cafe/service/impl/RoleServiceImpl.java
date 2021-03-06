package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.repository.RoleDao;
import by.itstep.cafe.dao.entity.Role;
import by.itstep.cafe.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    public Role addRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public void removeRole(int id) {
        roleDao.deleteById(id);
    }

    @Override
    public List listRoles() {
        return roleDao.findAll();
    }

    @Override
    public Role getRole(String name) {
        return roleDao.findByName(name);
    }
}
