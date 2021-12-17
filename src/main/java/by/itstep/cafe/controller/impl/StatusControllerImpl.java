package by.itstep.cafe.controller.impl;

import by.itstep.cafe.controller.StatusController;
import by.itstep.cafe.dao.entity.Role;
import by.itstep.cafe.dao.entity.Status;
import by.itstep.cafe.dao.entity.User;
import by.itstep.cafe.service.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusControllerImpl implements StatusController {

    private StatusService statusService;

    public StatusControllerImpl(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("statuses", statusService.listStatuses());

        return "status/index";
    }

    @GetMapping("/new")
    public String newStatus(Model model) {
        model.addAttribute("status", new Status());

        return "status/new";
    }

    @PostMapping()
    public String create(Status status, Model model) throws Exception {
        statusService.save(status);

        return "redirect:/status";
    }

    @GetMapping("delete/{id}")
    public String deleteStatus(@PathVariable("id") int id) {
        statusService.removeStatus(id);

        return "redirect:/status";
    }

    @GetMapping("edit/{id}")
    public String updateStatusForm(@PathVariable("id") int id, Model model) {
        Status status = statusService.findById(id);
        model.addAttribute("status", status);

        return "status/edit";
    }

    @PostMapping("/edit")
    public String updateStatus(Status status) throws Exception {
        statusService.save(status);

        return "redirect:/status";
    }

    @Override
    public void addStatus(Status status) {
        statusService.save(status);
    }

    @Override
    public void removeStatus(int id) {
        statusService.removeStatus(id);
    }

    @Override
    public List listStatuses() {
        return statusService.listStatuses();
    }

    @Override
    public Status getStatus(String name) {
        return statusService.getStatus(name);
    }
}
