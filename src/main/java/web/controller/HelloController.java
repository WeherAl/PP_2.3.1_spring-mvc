package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserServiceImp;

import java.util.List;

@Controller
public class HelloController {

    private UserServiceImp userServiceImp;

    @Autowired
    private HelloController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @RequestMapping(value = "/")
    public String printUsers(ModelMap model) {
        List<User> userList = userServiceImp.getAllUsers();
        model.addAttribute("usersList", userList);
        return "index";
    }


    @RequestMapping("/add-new-user")
    public String getCreateUserForm(@ModelAttribute("user") User user) {
        return "add-new-user";
    }

    @PostMapping("/")
    public String createUser(@ModelAttribute("user") User user) {
        userServiceImp.saveUser(user);
        return "redirect:/";

    }

    @RequestMapping("/{id}/edit")
    public String getEditForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServiceImp.getUserById(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userServiceImp.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/{id}/deleteUser")
    public String deleteUser(@PathVariable("id") int id) {
        userServiceImp.removeUserById(id);
        return "redirect:/";
    }


}
