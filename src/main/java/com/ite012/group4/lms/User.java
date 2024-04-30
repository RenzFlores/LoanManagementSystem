package com.ite012.group4.lms;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    String username = "";
    String password = "";
    String accountNumber = "";
    
    String name = "";
    String firstName = "";
    String middleName = "";
    String lastName = "";
    
    String unitNumber = "";
    String streetAddress = "";
    String cityAddress = "";
    String postalCode = "";
    
    String email = "";
    String contactNumber = "";
    
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
        
        String buf = Helpers.formatHashMapToString(data);
        
        // Write formatted string data to corresponding User data file
        try {
            FileWriter f = new FileWriter(".\\src\\main\\user_data\\" + username + ".txt");
            f.write(buf);
            f.close();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
    
    public static void loadAllUsers(ArrayList<User> userList) {
        
        String buffer = new String();
        
        String userDataDirectory = System.getProperty("user.dir") + "\\src\\main\\user_data\\";
        File dir = new File(userDataDirectory);
        
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File dataFile : directoryListing) {
                buffer = "";
                try {
                    java.io.BufferedReader f = new java.io.BufferedReader(new 
                        java.io.FileReader(dataFile));
                    String line = f.readLine();
                    
                    while (line != null) {
                        buffer += line;
                        buffer += "\n";
                        line = f.readLine();
                    }                    
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    userList.add(new User(Helpers.parseStringToHashMap(buffer)));
                }
            }
        }
        
    }    
    
    public User(HashMap<String, String> data) {
        username = data.get("username");
        password = data.get("password");
        firstName = data.get("first name");
        middleName = data.get("middle name");
        lastName = data.get("last name");
        email = data.get("email");
        contactNumber = data.get("contact number");
    }
    
    public User() {

    }

}
