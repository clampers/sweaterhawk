package com.sweaterhawk.sweaterhawk.models;

import java.util.List;

/**
 * Created by LaunchCode
 */

public class Item {

    private int id;

    private String name;

    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}