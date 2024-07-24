package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String edit(Model model, @RequestParam int id) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PatchMapping(value = "/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    @DeleteMapping()
    public String delete(@RequestParam("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

}
