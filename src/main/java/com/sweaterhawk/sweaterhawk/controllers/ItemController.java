package com.sweaterhawk.sweaterhawk.controllers;
import com.sweaterhawk.sweaterhawk.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "item")
public class ItemController {

    static ArrayList<Item> items = new ArrayList<>();

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
    public String processAddItemForm(@RequestParam String itemName, String itemDescription){
        Item newItem = new Item(itemName, itemDescription);
        items.add(newItem);
        return "redirect:/item/list";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveItemForm(Model model){
        model.addAttribute("items", items);
        model.addAttribute("title", "Remove Items");
        return "item/itemremove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveItemForm(@RequestParam ArrayList<String> item){
        for(String anItem : item){
            items.remove(anItem);
        }
        return "redirect:/item/list";
    }

}