package com.crkscore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@CrossOrigin(origins = "https://your-vercel-domain.vercel.app/admin.html")
    @GetMapping("/admin")
    public String adminView() {
        return "admin";
    }

	@CrossOrigin(origins = "https://your-vercel-domain.vercel.app/user.html")
    @GetMapping("/user")
    public String userView() {
        return "user";
    }
}
