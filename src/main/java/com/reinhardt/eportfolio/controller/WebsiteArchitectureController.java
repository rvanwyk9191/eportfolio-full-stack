package com.reinhardt.eportfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteArchitectureController {

    @GetMapping("/website-architecture")
    public String getResume(Model model){
        return "website-architecture";
    }

}
