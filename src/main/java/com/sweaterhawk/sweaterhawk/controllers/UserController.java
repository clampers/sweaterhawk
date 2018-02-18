package com.sweaterhawk.sweaterhawk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value="add")
    public String index(Model model){
        model.addAttribute("title", "add user");
        return "add";
    }
}
