package com.example.REST_task.controller;

import com.example.REST_task.model.Count;
import com.example.REST_task.model.Receipt;
import com.example.REST_task.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class ClientServiceController {
     private final ClientService clientService;

     private ClientServiceController(ClientService clientService) { this.clientService = clientService; }

     @RequestMapping(value = "/add-receipt", method = RequestMethod.POST)
     public String addReceipt (@ModelAttribute("receipt") Receipt receipt) {
       clientService.create(receipt);
       return "redirect:/get-receipts";
     }

     @RequestMapping(value = "/get-receipts", method = RequestMethod.GET)
     public String getReceipts (ModelMap map) {
          prepareModelMap(map, clientService.getReceipts(), clientService.getCount());
          return "index";
     }

     @RequestMapping(value = "/get-sum-day", method = RequestMethod.GET)
     public String getForToday () {
          clientService.getSumForThisDay();
          return "redirect:/get-receipts";
     }

     @RequestMapping(value = "/get-sum-week", method = RequestMethod.GET)
     public String getForWeek () {
          clientService.getSumForThisWeek();
          return "redirect:/get-receipts";
     }

     @RequestMapping(value = "/get-sum-month", method = RequestMethod.GET)
     public String getForMonth () {
          clientService.getSumForThisMonth();
          return "redirect:/get-receipts";
     }

     @RequestMapping(value = "/get-three-cat", method = RequestMethod.GET)
     public String getThreeCat () {
          clientService.get3MostCostlyCat();
          return "redirect:/get-receipts";
     }

     @RequestMapping(value = "/delete", method = RequestMethod.GET)
     public String delete () {
          clientService.delete();
          return "redirect:/get-receipts";
     }

     private void prepareModelMap (ModelMap map, List<Receipt> receipts, Count count) {
          map.addAttribute("receipts", receipts);
          map.addAttribute("receipt", new Receipt());
          map.addAttribute("count", count);
     }

}
