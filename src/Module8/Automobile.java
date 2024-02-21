package Module8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    public Automobile() {}

    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    public static String addVehicle(HashMap<String, Automobile> vehicleInventory, String name) {
        Scanner input = new Scanner(System.in);
        String make, model, color;
        int year, mileage;

        try {
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

            input.close();
        }
        catch (InputMismatchException inputError) {
            return "Could not add vehicle -- invalid input.";
        }

        // Create new Automobile object with new details
        Automobile automobile = new Automobile(make, model, color, year, mileage);

        // Add the vehicle to the list
        vehicleInventory.put(name, automobile);

        return "Vehicle successfully added to the list.";
    }

    public static String removeVehicle(HashMap<String, Automobile> vehicleInventory, String name) {
        // Assign a reference to the automobile that gets removed (in case it is null)
        Automobile removedVehicle = vehicleInventory.remove(name);

        // Check if the vehicle was not present in the inventory
        if (removedVehicle == null) {
            return "Cannot remove vehicle -- details do not match any vehicle in the list.";
        }

        return "Vehicle successfully removed from inventory";
    }

    public static String updateVehicle(HashMap<String, Automobile> vehicleInventory, String name) {
        Scanner input = new Scanner(System.in);

        // Get a reference to the requested vehicle
        Automobile vehicleToUpdate = vehicleInventory.get(name);

        // Check that the vehicle exists in the list
        if (vehicleToUpdate == null) {
            return "Cannot update vehicle -- details do not match any vehicle in the list";
        }

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

            input.close();

            return "Vehicle successfully updated.";
        }
        catch (InputMismatchException inputError) {
            return "Cannot update vehicle -- invalid input for new information.";
        }
    }

    public static String[] listVehicleInfo(HashMap<String, Automobile> vehicleInventory, String name) {
        // Initialize vehicleInfo with room for 5 values
        String[] vehicleInfo = new String[5];

        // Get the vehicle from the list
        Automobile vehicle = vehicleInventory.get(name);

        // Try to assign vehicle information to the array, or output error message if the specified vehicle
        // is not present in the inventory
        try {
            vehicleInfo[0] = "Make: " + vehicle.getMake();
            vehicleInfo[1] = "Model: " + vehicle.getModel();
            vehicleInfo[2] = "Color: " + vehicle.getColor();
            vehicleInfo[3] = "Year: " + Integer.toString(vehicle.getYear());
            vehicleInfo[4] = "Mileage: " + Integer.toString(vehicle.getMileage()) + " miles";

            return vehicleInfo;
        }
        catch (NullPointerException nullError) {
            return new String[]{"Invalid input -- no such vehicle in list"};
        }
    }

    public static String getNextVehicleName() {
        Scanner input = new Scanner(System.in);
        String name;

        System.out.print("Enter a vehicle name: ");
        name = input.nextLine();

        input.close();

        return name;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public int getYear() {
        return this.year;
    }

    public int getMileage() {
        return this.mileage;
    }
}
