package pe.com.jdmm21.reddit.app.redditclone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/")
    public String home(){
        return "hello xxxsd";
    }
    
}