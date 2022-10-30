package com.jagg.pruebaproyecto.controller;

import com.jagg.pruebaproyecto.entities.User;
import com.jagg.pruebaproyecto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
//        if (principal != null) {
//            User user = this.userService.getOrCreateUser(principal.getClaims());
//        }
        return "index";
    }

    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }

    public IndexController(UserService userService) {
        this.userService = userService;
    }
}
