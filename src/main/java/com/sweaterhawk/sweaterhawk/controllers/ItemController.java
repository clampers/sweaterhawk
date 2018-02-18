package com.sweaterhawk.sweaterhawk.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "item")
public class ItemController {

    static ArrayList<String> items = new ArrayList<>();

    @RequestMapping(value="list")
    public String index(Model model){


        model.addAttribute("items", items);
        model.addAttribute("title", "List All Items");
        return "item/itemlist";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddItemForm(Model model){
        model.addAttribute("title", "Add an Item");
        return "item/itemadd";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddItemForm(@RequestParam String itemName){
        items.add(itemName);
        return "redirect:/item/list";
    }

}