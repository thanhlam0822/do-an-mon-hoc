package com.example.comicweb.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class  RoleController {
    @GetMapping("/admin")
    public String adminRole() {
        return "This is admin role";
    }
    @GetMapping("/user")
    public String userRole() {
        return "This is user role";
    }
}