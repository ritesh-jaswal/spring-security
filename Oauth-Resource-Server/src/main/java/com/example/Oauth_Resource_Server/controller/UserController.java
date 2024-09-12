package com.example.Oauth_Resource_Server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @GetMapping("/api/users")
    public String[] getUser() {
        return new String[]{"Shabbir", "Nikhil","Shivam"};
    }
}
