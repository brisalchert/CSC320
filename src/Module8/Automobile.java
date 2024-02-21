package Module8;

import java.util.ArrayList;
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

    public String addVehicle(ArrayList<Automobile> vehicleList, String make, String model, String color,
                             int year, int mileage) {
        // Create new Automobile object
        Automobile newVehicle = new Automobile(make, model, color, year, mileage);

        // Add the vehicle to the list
        vehicleList.add(newVehicle);

        return "Vehicle successfully added to the list.";
    }

    public String removeVehicle(ArrayList<Automobile> vehicleList, String make, String model,
                                String color, int year) {
        if (vehicleList.remove(getVehicleFromList(vehicleList, make, model, color, year))) {
            return "Vehicle successfully removed from the list.";
        }

        return "Cannot remove vehicle -- details do not match any vehicle in the list.";
    }

    public Automobile getVehicleFromList(ArrayList<Automobile> vehicleList, String make, String model,
                                         String color, int year) {
        // Check each automobile in the list to see if it matches the input
        for (Automobile vehicle : vehicleList) {
            if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)
                && vehicle.getColor().equals(color) && vehicle.getYear() == year) {
                return vehicle;
            }
        }

        // If no vehicle in the list matches the input, return null
        return null;
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
