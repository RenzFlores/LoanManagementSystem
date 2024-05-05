package com.ite012.group4.lms;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.InputVerifier;

public class Helpers {
    
    // Converts a hashmap into a formatted string ready for file writing
    public static String formatHashMapToString(HashMap<String, String> data) {
        
        String buf = "";
        
        for ( String key : data.keySet() ) {
            buf += String.format("\"%s\": \"%s\"\n", key, data.get(key));
        }
        
        return buf;
    }
    
    // Parses a formatted string to a hashmap with key-value pairs
    public static HashMap<String, String> parseStringToHashMap(String s) {
        
        HashMap<String, String> data = new HashMap<String, String>();
        String[] keyValuePair = new String[2];
        String[] dataInString = s.split("\n");
        
        for (String pair : dataInString) {
            // Separate key and value strings
            keyValuePair = pair.split(": ");
            // Store the extracted strings in hashmap, removing the double quotations
            data.put(keyValuePair[0].substring(1, keyValuePair[0].length()-1), 
                    keyValuePair[1].substring(1, keyValuePair[1].length()-1));
        }

        return data;
        
    }
    
    /* 
     * This function checks for empty JTextFields in a JPanel and highlights
     * them in red. Returns false when all fields are not empty and true when an
     * empty field exists
     */
    public static boolean checkForEmptyFields(javax.swing.JPanel p) {
        
        ArrayList<JTextField> textFields = new ArrayList<JTextField>();
        boolean emptyFieldExists = false;
        
        // Get all JTextField components inside JPanel and store it in an 
        // ArrayList
        for (java.awt.Component c : p.getComponents()) {
            if (c instanceof JTextField) {
                textFields.add((JTextField) c);
            }
        }
        
        for (JTextField txt : textFields) {
            // Highlight text field border in red to warn user of an empty field
            if (txt.getText().equals("")) {
                txt.setBorder(new javax.swing.border.LineBorder(
                        new java.awt.Color(255, 102, 102), 1, true));
                emptyFieldExists = true;
            }
            // Reset the border color to black when a text field has content
            else {
                txt.setBorder(new javax.swing.border.LineBorder(
                        new java.awt.Color(0, 0, 0), 1, true));
            }
        }
        
        return emptyFieldExists;        
    }
    
    // Returns a formatted string that contains the current date and time.
    public static String getDateTime() {
        
        LocalDateTime dateTime = LocalDateTime.now();
        
        /*
         * Pattern for parsing taken from official docs. Read here:
         * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
         */
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, u");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm:ssa");
        
        String sDate = dateTime.format(dateFormat);
        String sTime = dateTime.format(timeFormat);
        
        return sDate + " " + sTime;
        
    }
    
    // Generate a string of random numbers from 0-9 of specified length
    public static String generateID(int length) {
        
        String id = "";
        Random rand = new Random();
        
        for (int i=0; i<length; i++) {
            // Add 1 random number to string
            id += (char) rand.nextInt(10);
        }
        
        return id;
    }
    
    /*
    public static void loadAllAdmins(ArrayList<Admin> adminList) {
        
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
                        adminList.add(new Admin(Helpers.parseStringToHashMap(buffer)));
                }
            }
        }
    }
    */
    
    public static void loadAllClients(ArrayList<Client> adminList) {
        
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
                        HashMap<String, String> data = Helpers.parseStringToHashMap(buffer);
                        adminList.add(new Admin(data));
                }
            }
        }
    }
    
    // JTextField verifier to prevent empty input
    public static class EmptyVerifier extends InputVerifier {
        @Override
        public boolean verify(javax.swing.JComponent input) {
            return "".equals(((JTextField) input).getText());
        }
    }  
    
}
