//----------------------------------------------------------------------------------------------------------------------
//  Automobile.java
//
//  A class for representing a generic vehicle in Java. Includes methods for modifying a HashMap inventory of
//  Automobile objects.
//----------------------------------------------------------------------------------------------------------------------

package Module8;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    /**
     * Default constructor: Creates an Automobile object with no parameters, setting fields to default values
     */
    public Automobile() {
        this.make = "none";
        this.model = "none";
        this.color = "none";
        this.year = 0;
        this.mileage = 0;
    }

    /**
     * Parameterized Constructor: Creates a new Automobile object with parameters for each field
     * @param make the make of the vehicle
     * @param model the model of the vehicle
     * @param color the color of the vehicle
     * @param year the year of the vehicle
     * @param mileage the current mileage of the vehicle
     */
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    /**
     * Adds a vehicle to a HashMap inventory, creating the vehicle in the process
     * @param automobileInventory the HashMap of vehicles
     * @param name the name for the new vehicle in the HashMap
     * @return a message indicating success or failure
     */
    public static String addVehicle(HashMap<String, Automobile> automobileInventory, String name) {
        // Check if name already exists in HashMap
        if (automobileInventory.containsKey(name)) {
            System.out.println();

            return "Could not add vehicle -- name \"" + name + "\" already exists in inventory.";
        }

        Scanner input = new Scanner(System.in);
        String make, model, color;
        int year, mileage;

        try {
            System.out.println();
            System.out.println("Adding new vehicle:");
            System.out.println("------------------------------");

            // Prompt the user for info for new vehicle
            System.out.print("Enter a make: ");
            make = input.next();

            System.out.print("Enter a model: ");
            model = input.next();

            System.out.print("Enter a color: ");
            color = input.next();

            System.out.print("Enter a year: ");
            year = input.nextInt();

            System.out.print("Enter mileage: ");
            mileage = input.nextInt();
        }
        catch (InputMismatchException inputError) {
            System.out.println();

            return "Could not add vehicle -- invalid input.";
        }

        // Create new Automobile object with new details
        Automobile automobile = new Automobile(make, model, color, year, mileage);

        // Add the vehicle to the list
        automobileInventory.put(name, automobile);

        System.out.println();

        return "Vehicle \"" + name + "\" successfully added to the list.";
    }

    /**
     * Adds a vehicle to a HashMap inventory, using an existing Automobile object
     * @param automobileInventory the HashMap of vehicles
     * @param automobile the Automobile object
     * @param name the name for the vehicle in the HashMap
     * @return a message indicating success or failure
     */
    public static String addVehicle(HashMap<String, Automobile> automobileInventory, Automobile automobile,
                                    String name) {
        // Check if name already exists in HashMap
        if (automobileInventory.containsKey(name)) {
            System.out.println();

            return "Could not add vehicle -- name \"" + name + "\" already exists in inventory.";
        }

        automobileInventory.put(name, automobile);

        System.out.println();

        return "Vehicle \"" + name + "\" successfully added to the list.";
    }

    /**
     * Removes a vehicle from a HashMap inventory, if it is present
     * @param automobileInventory the HashMap of vehicles
     * @param name the name of the vehicle to remove from the HashMap
     * @return a message indicating success or failure
     */
    public static String removeVehicle(HashMap<String, Automobile> automobileInventory, String name) {
        // Check if the inventory is empty
        if (automobileInventory.isEmpty()) {
            return "Cannot remove vehicle -- inventory is empty.";
        }

        // Check if the HashMap does NOT have the specified key
        if (!automobileInventory.containsKey(name)) {
            return "Cannot remove vehicle -- name \"" + name +"\" does not exist in inventory.";
        }

        // Remove the vehicle
        automobileInventory.remove(name);

        return "Vehicle \"" + name + "\" successfully removed from inventory.";
    }

    /**
     * Updates the details of a pre-existing vehicle in a HashMap inventory, if it is present
     * @param automobileInventory the HashMap of vehicles
     * @param name the name of the vehicle to update in the HashMap
     * @return a message indicating success or failure
     */
    public static String updateVehicle(HashMap<String, Automobile> automobileInventory, String name) {
        Scanner input = new Scanner(System.in);

        // Get a reference to the requested vehicle
        Automobile vehicleToUpdate = automobileInventory.get(name);

        // Check that the vehicle exists in the list
        if (vehicleToUpdate == null) {
            System.out.println();

            return "Cannot update vehicle -- name \"" + name + "\" does not match any vehicle in the list.";
        }

        System.out.println("Updating info for " + name + ":");
        System.out.println("------------------------------");

        // Attempt to update the vehicle with new attributes from the user
        try {
            System.out.print("Enter a new make: ");
            vehicleToUpdate.make = input.next();

            System.out.print("Enter a new model: ");
            vehicleToUpdate.model = input.next();

            System.out.print("Enter a new color: ");
            vehicleToUpdate.color = input.next();

            System.out.print("Enter a new year: ");
            vehicleToUpdate.year = input.nextInt();

            System.out.print("Enter a new mileage: ");
            vehicleToUpdate.mileage = input.nextInt();

            System.out.println();

            return "Vehicle \"" + name + "\" successfully updated.";
        }
        catch (InputMismatchException inputError) {
            System.out.println();

            return "Cannot update vehicle -- invalid input for new information.";
        }
    }

    /**
     * Provides a String array of all vehicle information for the specified vehicle in a HashMap inventory
     * @param automobileInventory the HashMap of vehicles
     * @param name the name of the vehicle in the HashMap
     * @return the array of vehicle information, or a single-element array with a message indicating failure
     */
    public static String[] listVehicleInfo(HashMap<String, Automobile> automobileInventory, String name) {
        // Initialize vehicleInfo with room for 5 values
        String[] vehicleInfo = new String[5];

        // Get the vehicle from the list
        Automobile vehicle = automobileInventory.get(name);

        // Try to assign vehicle information to the array, or output error message if the specified vehicle
        // is not present in the inventory
        try {
            vehicleInfo[0] = "Make: " + vehicle.getMake();
            vehicleInfo[1] = "Model: " + vehicle.getModel();
            vehicleInfo[2] = "Color: " + vehicle.getColor();
            vehicleInfo[3] = "Year: " + (vehicle.getYear());
            vehicleInfo[4] = "Mileage: " + (vehicle.getMileage()) + " miles";

            return vehicleInfo;
        }
        catch (NullPointerException nullError) {
            return new String[]{"Invalid input -- no such vehicle in list."};
        }
    }

    /**
     * Prompts the user for the next vehicle name for use in method calls
     * @return the name of the vehicle
     */
    public static String getNextVehicleName() {
        Scanner input = new Scanner(System.in);
        String name;

        System.out.print("Enter a vehicle name: ");
        name = input.nextLine();

        return name;
    }

    /**
     * Formats and prints the vehicle information from the listVehicleInfo method for a vehicle in a HashMap Inventory
     * @param automobileInventory the HashMap of vehicles
     * @param name the name of the vehicle in the HashMap
     */
    public static void printVehicleInfo(HashMap<String, Automobile> automobileInventory, String name) {
        String[] vehicleInfo = listVehicleInfo(automobileInventory, name);

        System.out.println("Vehicle Info for " + name + ":");
        System.out.println("------------------------------");

        for (String value : vehicleInfo) {
            System.out.println("\t" + value);
        }

        System.out.println();
    }

    public static void printInventory(HashMap<String, Automobile> automobileInventory) {
        System.out.println("VEHICLE INVENTORY:");
        System.out.println("------------------------------------------------------------");

        // Print vehicle information for each vehicle in the inventory
        for (String vehicleName : automobileInventory.keySet()) {
            printVehicleInfo(automobileInventory, vehicleName);
        }
    }

    public static void printToFile(HashMap<String, Automobile> automobileInventory) {
        Scanner input = new Scanner(System.in);
        String userInput;

        System.out.println("Export automobile inventory to file (Y/N)?");

        userInput = input.nextLine();

        System.out.println();

        switch (userInput) {
            case "Y":
                try {
                    // Create a new file a PrintStream
                    PrintStream fileStream = new PrintStream("C:/Temp/Autos.txt");

                    // Save a reference of the console output stream
                    PrintStream console = System.out;

                    // Set the output stream to the file
                    System.setOut(fileStream);

                    // Print the inventory to the file
                    printInventory(automobileInventory);

                    // Set output stream back to the console
                    System.setOut(console);

                    System.out.println("Inventory exported to file.");
                }
                catch (FileNotFoundException error) {
                    System.out.println("Error exporting to file: file not found.");
                }

                break;
            case "N":
                System.out.println("Inventory not exported to file.");

                break;
            default:
                System.out.println("Invalid input -- inventory not exported to file.");
        }
    }

    /**
     * Accessor method for the Automobile's make
     * @return the make of the Automobile
     */
    public String getMake() {
        return this.make;
    }

    /**
     * Accessor method for the Automobile's model
     * @return the model of the Automobile
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Accessor method for the Automobile's color
     * @return the color of the Automobile
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Accessor method for the Automobile's year
     * @return the year of the Automobile
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Accessor method for the Automobile's current mileage
     * @return the current mileage of the Automobile
     */
    public int getMileage() {
        return this.mileage;
    }
}
