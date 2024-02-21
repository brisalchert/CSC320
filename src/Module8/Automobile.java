package Module8;

import java.util.ArrayList;
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

    public String updateVehicle(ArrayList<Automobile> vehicleList, String make, String model,
                                String color, int year) {
        Scanner input = new Scanner(System.in);

        // Get a reference to the requested vehicle
        Automobile vehicleToUpdate = getVehicleFromList(vehicleList, make, model, color, year);

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

            return "Vehicle successfully updated.";
        }
        catch (InputMismatchException inputError) {
            return "Cannot update vehicle -- invalid input for new information.";
        }
    }

    public String[] listVehicleInfo(ArrayList<Automobile> vehicleList, String make, String model,
                                    String color, int year) {
        // Initialize vehicleInfo with room for 5 values
        String[] vehicleInfo = new String[5];

        // Get the vehicle from the list
        Automobile vehicle = getVehicleFromList(vehicleList, make, model, color, year);

        try {
            vehicleInfo[0] = vehicle.getMake();
            vehicleInfo[1] = vehicle.getModel();
            vehicleInfo[2] = vehicle.getColor();
            vehicleInfo[3] = Integer.toString(vehicle.getYear());
            vehicleInfo[4] = Integer.toString(vehicle.getMileage());

            return vehicleInfo;
        }
        catch (NullPointerException nullError) {
            return new String[]{"Invalid input -- no such vehicle in list"};
        }
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
