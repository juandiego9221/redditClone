package pe.com.jdmm21.reddit.app.redditclone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthViewController {
 
    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }
}