package com.ite012.group4.lms;

import java.util.HashMap;

public class Application {
    public static int PENDING = 0;
    public static int APPROVED = 1;
    public static int DENIED = 2;
    
    String username;
    String password;
    String accountNumber;
    String name;
    String firstName;
    String middleName;
    String lastName;
    String email;
    String contactNumber;
    String path;
    
    public Application(java.util.HashMap<String, String> data) {
        // Initialize
        path = data.get("path");
    }
    
    public void saveApplication() {
        
    }
    
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> data = new HashMap<>();
        
        data.put("username", username);
        
        return data;
    }
    
}
