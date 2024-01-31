package com.example.crud231.controller;

import com.example.crud231.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.crud231.service.UserService;


import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/new")
    public String newPerson(User user) {
        return "new";
    }

    @PostMapping("/create")
    public String add(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        } else {
            userService.addUser(user);
            return "redirect:/users";
        }
    }

    @GetMapping("/id")
    public String getUser(@RequestParam(value = "id", required = false) Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam(value = "id", required = false) Long id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "edituser";
    }

    @PostMapping("/edit")
    public String update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edituser";
        } else {
            userService.updateUser(user);
            return "redirect:/users";
        }
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(value = "id", required = false) Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
