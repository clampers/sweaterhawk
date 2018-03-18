package com.sweaterhawk.sweaterhawk.controllers;

import com.sweaterhawk.sweaterhawk.models.Item;
import com.sweaterhawk.sweaterhawk.models.User;
import com.sweaterhawk.sweaterhawk.models.data.ItemDao;
import com.sweaterhawk.sweaterhawk.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "item")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="list")
    public String index(Model model){


        model.addAttribute("items", itemDao.findAll());
        model.addAttribute("title", "List All Items");
        return "item/itemlist";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddItemForm(Model model){
        model.addAttribute("title", "Add an Item");
        model.addAttribute(new Item());
        model.addAttribute("users", userDao.findAll());
        return "item/itemadd";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddItemForm(@ModelAttribute @Valid Item newItem,
                                     Errors errors,
                                     @RequestParam int userId,
                                     Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Item");
            return "item/itemadd";
        }
        User user = userDao.findOne(userId);
        newItem.setUser(user);
        itemDao.save(newItem);
        return "redirect:/item/list";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveItemForm(Model model){
        model.addAttribute("items", itemDao.findAll());
        model.addAttribute("title", "Remove Items");
        return "item/itemremove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveItemForm(@RequestParam int[] itemIds){
        for(int itemId : itemIds){
            itemDao.delete(itemId);
        }
        return "redirect:/item/list";
    }

}