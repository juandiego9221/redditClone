package pe.com.jdmm21.reddit.app.redditclone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pe.com.jdmm21.reddit.app.redditclone.service.UserService;

@Controller
public class AuthViewController {

    private UserService userService;

    public AuthViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "auth/profile";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }
}