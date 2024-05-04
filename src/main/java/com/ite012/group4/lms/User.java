package com.ite012.group4.lms;

import java.util.HashMap;
import java.io.FileWriter;

public abstract class User {
    
    String username;
    String password;
    String accountNumber;
    int accountType = 0;
    
    String name;
    String firstName;
    String middleName;
    String lastName;
    
    String email;
    
    public abstract void saveUserData();
}    

class Admin extends User {
    
    int accountType = 0;
    
    public void saveUserData() {
        HashMap<String, String> data = new HashMap<String, String>();
        
        data.put("username", username);
        data.put("password", password);
        data.put("first name", firstName);
        data.put("middle name", middleName);
        data.put("last name", lastName);
        data.put("name", name);
        data.put("email", email);
        
        String buf = Helpers.formatHashMapToString(data);
        
        // Write formatted string data to corresponding User data file
        try {
            FileWriter f = new FileWriter(".\\src\\main\\user_data\\admin\\" + username + ".txt");
            f.write(buf);
            f.close();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public Admin(HashMap<String, String> data) {
        username = data.get("username");
        password = data.get("password");
        firstName = data.get("first name");
        middleName = data.get("middle name");
        lastName = data.get("last name");
        email = data.get("email");
        accountNumber = Helpers.generateID(9);
    }
}

class Client extends User {
    
    String unitAddress = "";
    String streetAddress = "";
    String cityAddress = "";
    String postalCode = "";
    
    String contactNumber = "";
    
    // Write user data to a txt file
    public void saveUserData() {
        HashMap<String, String> data = new HashMap<String, String>();
        
        data.put("username", username);
        data.put("password", password);
        data.put("first name", firstName);
        data.put("middle name", middleName);
        data.put("last name", lastName);
        data.put("name", name);
        data.put("email", email);
        data.put("contact number", contactNumber);
        data.put("unitAddress", unitAddress);
        data.put("streetAddress", streetAddress);
        data.put("cityAddress", cityAddress);
        data.put("postalCode", postalCode);
        
        String buf = Helpers.formatHashMapToString(data);
        
        // Write formatted string data to corresponding User data file
        try {
            FileWriter f = new FileWriter(".\\src\\main\\user_data\\client\\" + username + ".txt");
            f.write(buf);
            f.close();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    // Constructor
    public Client(HashMap<String, String> data) {
        username = data.get("username");
        password = data.get("password");
        firstName = data.get("first name");
        middleName = data.get("middle name");
        lastName = data.get("last name");
        email = data.get("email");
        contactNumber = data.get("contact number");
        unitAddress = data.get("unitAddress");
        streetAddress = data.get("streetAddress");
        cityAddress = data.get("cityAddress");
        postalCode = data.get("postalCode");
    }
}

/*
 * DEV NOTE: 
 * - Two types of user: Client and admin
 * - Both have similar and unique attributes
 * - Due to this, both have different constructors
 * - And overrides the save/load functions
 * - 
 *
*/