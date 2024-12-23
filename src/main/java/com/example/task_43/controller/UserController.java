package com.example.task_43.controller;
import com.example.task_43.model.User;
import com.example.task_43.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // страница реги
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // метод для создания нового пользователя
    @PostMapping("/register")
    public String registerUser(User user) {
        userService.register(user);
        return "redirect:/login";
    }

    // страница входа
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // главная страница
    @GetMapping("/home")
    public String home() {
        return "home";
    }

}