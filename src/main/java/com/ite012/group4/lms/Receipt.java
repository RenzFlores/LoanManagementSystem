package com.ite012.group4.lms;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Receipt {
    
    LocalDateTime dateTime;
    String formattedDateTime;
    double amount;
    String refID;
    String path;
    
    public Receipt(LocalDateTime dateTime, double amount, String path) {
        this.dateTime = dateTime;
        this.amount = amount;
        this.formattedDateTime = Helpers.getFormattedDateTime(dateTime);
        this.path = path;
        refID = Helpers.generateID(12);
    }
    
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> data = new HashMap<>();
        
        data.put("dateTime", formattedDateTime);
        data.put("amount", String.valueOf(amount));
        data.put("refID", refID);
        data.put("path", path);
        
        return data;
    }
    
}
