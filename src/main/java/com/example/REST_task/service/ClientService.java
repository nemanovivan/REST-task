package com.example.REST_task.service;

import com.example.REST_task.model.Count;
import com.example.REST_task.model.Receipt;
import java.util.List;
import java.util.Optional;


public interface ClientService {

    void create(Receipt receipt);
    void getSumForThisDay();
    void getSumForThisWeek();
    void getSumForThisMonth();
    void get3MostCostlyCat();
    List<Receipt> getReceipts();
    public Count getCount();
    void  delete ();




}
