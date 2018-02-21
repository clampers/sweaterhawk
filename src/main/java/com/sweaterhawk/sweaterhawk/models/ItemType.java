package com.sweaterhawk.sweaterhawk.models;

public enum ItemType {

    COAT ("Coat"),
    JACKET ("Jacket"),
    DRESS ("Dress");

    private final String name;

    ItemType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
