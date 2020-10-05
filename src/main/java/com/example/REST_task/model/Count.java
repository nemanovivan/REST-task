package com.example.REST_task.model;

import java.util.List;

public class Count {
    private String output;
    private String firstCategory;
    private String secondCategory;
    private String thirdCategory;

    public Count () {

    }

    public Count (String output, String firstCategory, String secondCategory, String thirdCategory) {
        this.output = output;
        this.firstCategory = firstCategory;
        this.secondCategory = secondCategory;
        this.thirdCategory = thirdCategory;
    }

    public void setOutput (String output) { this.output = output; }

    public String getOutput () { return this.output; }

    public void setFirstCategory (String firstCategory) { this.firstCategory = firstCategory; }

    public String getFirstCategory() { return this.firstCategory; }

    public void setSecondCategory(String secondCategory) { this.secondCategory = secondCategory; }

    public String getSecondCategory() { return this.secondCategory; }

    public void setThirdCategory(String thirdCategory) { this.thirdCategory = thirdCategory; }

    public String getThirdCategory() { return this.thirdCategory; }
}
