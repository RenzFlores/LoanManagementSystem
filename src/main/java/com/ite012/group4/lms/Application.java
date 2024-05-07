package com.ite012.group4.lms;

import java.io.FileReader;
import java.util.HashMap;
import java.util.ArrayList;

public class Application {
    public static int PENDING = 0;
    public static int APPROVED = 1;
    public static int DENIED = 2;
    
    public static ArrayList<Application> applications;
    
    String name;
    String accountNumber;
    String email;
    String contactNumber;
    String unitNumber;
    String streetAddress;
    String city;
    String stateProvince ;
    String postalCode;
    String loanableAmount;
    String bank;
    String bankAccountNumber;
    int status;
    
    public Application(java.util.HashMap<String, String> data) {
        name = data.get("name");
        accountNumber = data.get("account number");
        email = data.get("email");
        contactNumber = data.get("contact number");
        unitNumber = data.get("unit number");
        streetAddress = data.get("street address");
        city = data.get("city");
        stateProvince = data.get("state province");
        postalCode = data.get("postal code");
        loanableAmount = data.get("loanable amount");
        bank = data.get("bank");
        bankAccountNumber = data.get("bank account number");
        status = Integer.parseInt(data.get("status"));
        
        applications.add(this);
    }
    
    public void Application() {
        String buffer = Helpers.formatHashMapToString(toHashMap());
    }
    
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> data = new HashMap<>();
        
        data.put("name", name);
        data.put("account number", accountNumber);
        data.put("email", email);
        data.put("contact number", contactNumber);
        data.put("unit number", unitNumber);
        data.put("street address", streetAddress);
        data.put("city", city);
        data.put("state province", stateProvince);
        data.put("postal code", postalCode);
        data.put("loanable amount", loanableAmount);
        data.put("bank", bank);
        data.put("bank account number", bankAccountNumber);
        data.put("status", String.valueOf(status));
        
        return data;
    }
    
    public static void loadAllApplications() {
        
        String line;
        
        try {
            java.io.BufferedReader f = new java.io.BufferedReader(new FileReader(
                    String.format("./src/main/user_data/applications.txt")));
            while ((line=f.readLine()) != null) {
                
            }
            new Application();
            f.close();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
