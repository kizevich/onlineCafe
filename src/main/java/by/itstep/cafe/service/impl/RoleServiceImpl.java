package by.itstep.cafe.service.impl;

import by.itstep.cafe.dao.repository.RoleDao;
import by.itstep.cafe.dao.entity.Role;
import by.itstep.cafe.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    public Role save(Role role) {
        return roleDao.save(role);
    }

    @Override
    public void removeRole(int id) {
        roleDao.deleteById(id);
    }

    @Override
    public List<Role> listRoles() {
        return roleDao.findAll();
    }

    @Override
    public Role getRole(String name) throws Exception {
        Optional<Role> optionalRole = roleDao.findByName(name);

        if (optionalRole.isPresent()){

            return optionalRole.get();
        } else {
            throw new Exception("role is not exist");
        }    }

    @Override
    public Role findById(int id) throws Exception {
        Optional<Role> optionalRole = roleDao.findById(id);

        if (optionalRole.isPresent()){

            return optionalRole.get();
        } else {
            throw new Exception("role is not exist");
        }
    }
}
