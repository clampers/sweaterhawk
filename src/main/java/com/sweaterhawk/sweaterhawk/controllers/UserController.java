package com.sweaterhawk.sweaterhawk.controllers;

import com.sweaterhawk.sweaterhawk.models.User;
import com.sweaterhawk.sweaterhawk.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model){
        model.addAttribute("title", "Register a User");
        model.addAttribute(new User());
        return "user/useradd";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User newUser,
                                     Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Item");
            return "user/useradd";
        }
        userDao.save(newUser);
        return "redirect:/";
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String displayUserLoginForm(Model model){
        model.addAttribute("title", "Login");
        model.addAttribute(new User());
        return "user/userlogin";
    }

}