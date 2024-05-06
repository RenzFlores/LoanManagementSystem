package com.ite012.group4.lms;

import java.util.HashMap;
import java.io.FileWriter;
import java.io.File;

public abstract class User {
    
    static int ADMIN = 0;
    static int CLIENT = 1;
    
    String username;
    String password;
    String accountNumber;
    
    String name;
    String firstName;
    String middleName;
    String lastName;
    
    String email;
    String contactNumber;
    
    public abstract void saveUserData();
    public abstract String getAccountTypeInWords();
    public abstract String getFormattedPassword();
}    

class Admin extends User {
    
    int accountType = User.ADMIN;
    
    public void saveUserData() {
        HashMap<String, String> data = new HashMap<String, String>();
        
        data.put("username", username);
        data.put("password", password);
        data.put("account type", String.valueOf(accountType));
        data.put("account number", accountNumber);
        data.put("first name", firstName);
        data.put("middle name", middleName);
        data.put("last name", lastName);
        data.put("name", name);
        data.put("email", email);
        data.put("contact number", contactNumber);
        
        String buf = Helpers.formatHashMapToString(data);
        
        // Write formatted string data to corresponding User data file
        try {
            FileWriter f = new FileWriter(String.format(
                    "./src/main/user_data/admin/%s/%s.txt", username, username));
            f.write(buf);
            f.close();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public Admin(HashMap<String, String> data) {
        new File(String.format("./src/main/user_data/admin/%s", username)).mkdirs();
        username = data.get("username");
        password = data.get("password");
        firstName = data.get("first name");
        middleName = data.get("middle name");
        lastName = data.get("last name");
        name = data.get("name");
        email = data.get("email");
        contactNumber = data.get("contactNumber");
        accountNumber = Helpers.generateID(6);
    }
    
    public String getAccountTypeInWords() {
        return "Admin";
    }
    
    public String getFormattedPassword() {
        return password.replaceAll(".", "*");
    }
}

class Client extends User {
    
    int accountType = User.CLIENT;

    /*
    String unitAddress = "";
    String streetAddress = "";
    String cityAddress = "";
    String postalCode = "";
    */
    
    // Write user data to a txt file
    public void saveUserData() {
        HashMap<String, String> data = new HashMap<String, String>();
        
        data.put("username", username);
        data.put("password", password);
        data.put("account type", String.valueOf(accountType));
        data.put("account number", accountNumber);
        data.put("first name", firstName);
        data.put("middle name", middleName);
        data.put("last name", lastName);
        data.put("name", name);
        data.put("email", email);
        data.put("contact number", contactNumber);
        
        /*
        data.put("unit address", unitAddress);
        data.put("street address", streetAddress);
        data.put("city address", cityAddress);
        data.put("postal code", postalCode);
        */
        
        String buf = Helpers.formatHashMapToString(data);
        
        // Write formatted string data to corresponding User data file
        try {
            FileWriter f = new FileWriter(String.format(
                    "./src/main/user_data/client/%s/%s.txt", username, username));
            f.write(buf);
            f.close();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    // Constructor
    public Client(HashMap<String, String> data) {
        new File(String.format("./src/main/user_data/client/%s", username)).mkdirs();
        new File(String.format("./src/main/user_data/client/%s/loan", username)).mkdirs();
        username = data.get("username");
        password = data.get("password");
        firstName = data.get("first name");
        middleName = data.get("middle name");
        lastName = data.get("last name");
        name = data.get("name");
        email = data.get("email");
        contactNumber = data.get("contact number");
        /*
        unitAddress = data.get("unit address");
        streetAddress = data.get("street address");
        cityAddress = data.get("city address");
        postalCode = data.get("postal code");
        */
        accountNumber = Helpers.generateID(6);
    }
    
    public String getAccountTypeInWords() {
        return "Client";
    }
    
    public String getFormattedPassword() {
        return password.replaceAll(".", "*");
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