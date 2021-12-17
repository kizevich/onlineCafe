package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.RoleController;
import by.itstep.cafe.dao.entity.Role;
import by.itstep.cafe.dao.entity.Status;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleControllerImpl implements RoleController {

    private RoleService roleService;

    public RoleControllerImpl(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("roles", roleService.listRoles());

        return "role/index";
    }

    @GetMapping("/new")
    public String newRole(Model model) {
        model.addAttribute("role", new Role());

        return "role/new";
    }

    @PostMapping()
    public String create(Role role, Model model) throws Exception {
        roleService.save(role);

        return "redirect:/role";
    }

    @GetMapping("delete/{id}")
    public String deleteRole(@PathVariable("id") int id) {
        roleService.removeRole(id);

        return "redirect:/role";
    }

    @GetMapping("edit/{id}")
    public String updateRoleForm(@PathVariable("id") int id, Model model) {
        Role role = roleService.findById(id);
        model.addAttribute("role", role);

        return "role/edit";
    }

    @PostMapping("/edit")
    public String updateRole(Role role) throws Exception {
        roleService.save(role);

        return "redirect:/role";
    }

    @Override
    public Role addRole(Role role) {
        return roleService.save(role);
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
