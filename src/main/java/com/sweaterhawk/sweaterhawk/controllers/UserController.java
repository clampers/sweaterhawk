package com.sweaterhawk.sweaterhawk.controllers;

import com.sweaterhawk.sweaterhawk.models.User;
import com.sweaterhawk.sweaterhawk.models.data.UserDao;
import com.sweaterhawk.sweaterhawk.models.EmailValidator;
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
    public String processAddUserForm(Model model, @ModelAttribute @Valid User newUser,
                                     Errors errors, String verify){
        String comparePassword = newUser.getPassword();
        if(errors.hasErrors()){
            model.addAttribute("title", "Register a User");
            model.addAttribute(newUser);
            return "user/useradd";
        }
        if(comparePassword.equals(verify)){
            userDao.save(newUser);
            return "redirect:/item/list";
        } else {
            model.addAttribute("title", "Register a User");
            model.addAttribute("verifyerror", "Password don't match.");
            model.addAttribute(newUser);
            newUser.setPassword("");
            return "user/useradd";
        }

    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String displayUserLoginForm(Model model){
        model.addAttribute("title", "Login");
        model.addAttribute(new User());
        return "user/userlogin";
    }

}