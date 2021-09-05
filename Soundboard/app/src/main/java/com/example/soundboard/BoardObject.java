package com.example.soundboard;

public class BoardObject {
    private String itemName;
    private Integer itemID;
    public BoardObject(String itemName, Integer itemID) {
        this.itemName = itemName;
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getItemID() {
        return itemID;
    }
}
