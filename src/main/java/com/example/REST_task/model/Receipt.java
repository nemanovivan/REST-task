package com.example.REST_task.model;

import java.time.LocalDateTime;

public class Receipt {

    private int id;
    private String category;
    private String name;
    private String number;
    private String store;
    private LocalDateTime date;
    private String dateString;
    private String time;
    private int price;

    public Receipt(){

    }

    public Receipt(int id, String category, String name, String number, String store, String dateString, String time, int price){
        this.id = id;
        this.category = category;
        this.name = name;
        this.number = number;
        this.store = store;
        this.dateString = dateString;
        this.time = time;
        this.price = price;
    }

    public int getId() { return this.id; }

    public void setId(int id){ this.id = id; }

    public String getCategory() { return this.category; }

    public void setCategory(String category) { this.category = category; }

    public String getName() { return this.name; }

    public void setName (String name) { this.name = name; }

    public String getNumber() { return this.number; }

    public void setNumber(String number) { this.number = number;}

    public String getStore () { return this.store; }

    public void setStore (String store) { this.store = store; }

    public LocalDateTime getDate () { return this.date; }

    public void setDate (LocalDateTime date) { this.date = date; }

    public int getPrice () { return this.price; }

    public void setPrice (int price) { this.price = price; }

    public String getDateString () { return this.dateString; }

    public void setDateString(String dateString) { this.dateString = dateString; }

    public String getTime () { return this.time; }

    public void setTime (String time) { this.time = time; }

}
