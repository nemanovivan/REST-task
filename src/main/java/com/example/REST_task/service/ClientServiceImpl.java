package com.example.REST_task.service;

import com.example.REST_task.model.Count;
import com.example.REST_task.model.Receipt;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientServiceImpl implements ClientService {
    private final AtomicInteger lastid = new AtomicInteger(0);
    private final List<Receipt> receipts = new CopyOnWriteArrayList<>();
    private final Count count = new Count();

    @Override
    public void create(Receipt receipt) {
        int id = lastid.incrementAndGet();
        receipt.setId(id);
        receipt.setDate(LocalDateTime.parse(receipt.getDateString()));
        receipts.add(receipt);
    }

    @Override
    public void getSumForThisDay() {
        int sum = 0;
        for (Receipt receipt : receipts) {
           if (LocalDate.now().equals(receipt.getDate().toLocalDate())) {
               sum += receipt.getPrice();
           }
        }
        count.setOutput("For today: " + sum);
    }

    @Override
    public void getSumForThisWeek() {
        int sum = 0;
        LocalDate firstDayOfWeek = LocalDate.now();
        while (firstDayOfWeek.getDayOfWeek() != DayOfWeek.MONDAY) {
            firstDayOfWeek = firstDayOfWeek.minusDays(1);
        }
        for (Receipt receipt : receipts) {
            if (firstDayOfWeek.equals(receipt.getDate().toLocalDate()) ||
                    receipt.getDate().toLocalDate().isAfter(firstDayOfWeek)) {
                sum += receipt.getPrice();
            }
        }
        count.setOutput("For this week: " + sum);
    }

    @Override
    public void getSumForThisMonth() {
        int sum = 0;
        for (Receipt receipt : receipts) {
            if (LocalDate.now().getMonth() == receipt.getDate().toLocalDate().getMonth() &&
                    LocalDate.now().getYear() == receipt.getDate().toLocalDate().getYear()) {
                sum += receipt.getPrice();
            }
        }
        count.setOutput("For this month: " + sum);
    }

    @Override
    public void get3MostCostlyCat() {
        class CatSum {
            int sum;
            String name;

            public CatSum(int sum, String name) {
                this.sum = sum;
                this.name = name;
            }
        }
    }

    @Override
    public List<Receipt> getReceipts() {
        return List.copyOf(receipts);
    }

    public Count getCount () { return this.count; }

    @Override
    public void delete() {

    }
}
