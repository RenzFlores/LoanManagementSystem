package attendancesystem;

public class Admin {
    
    // Variable declaration. Example variables only palitan mo na lang
    String name;
    java.time.LocalDateTime[] attendanceRecord = new java.time.LocalDateTime[30];
    int numberOfDaysPresent;
    int numberOfDaysAbsent;
    int numberOfDaysLate;
    
    // Example function for exporting user data to files
    public void saveToFile(/*Arguments*/) {
        /* Example algo:
         * 1. Try creating file, if error, throw exception and exit program
         * 2. Write all variables into file
         * 3. Close file
        */
    }
    
    // Example function for importing user data into program
    public void loadFromFile(/*Arguments*/) {
        /* Example algo:
         * 1. Try opening file, if error, throw exception and exit program
         * 2. Read file contents
         * 3. Parse contents and assign the values to variables
         * 3. Close file
        */
    }
    
    // Constructor
    public Admin(/*Arguments*/) {
        // Initialize your variables here
    }
}
