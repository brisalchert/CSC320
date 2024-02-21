package Module8;

import java.util.HashMap;
import java.util.Scanner;

public class AutomobileInventory {
    public static void main(String[] args) {
        // Initialize automobile inventory
        HashMap<String, Automobile> automobileInventory = new HashMap<>();
        Scanner input = new Scanner(System.in);
        String returnMessage;
        String[] vehicleInfo;

        // Create a vehicle using the parameterized constructor
        Automobile firstVehicle = new Automobile("Subaru", "Impreza", "Gray", 2018, 56000);

        // Add the first vehicle to the inventory
        String firstVehicleName = "Brian's car";
        Automobile.addVehicle(automobileInventory, firstVehicle, firstVehicleName);

        // List the vehicle values
        vehicleInfo = Automobile.listVehicleInfo(automobileInventory, firstVehicleName);

        System.out.println("Vehicle Info for " + firstVehicleName + ":");
        System.out.println("------------------------------");

        for (String value : vehicleInfo) {
            System.out.println("\t" + value);
        }

        System.out.println();

        // Remove the vehicle and print the return value
        returnMessage = Automobile.removeVehicle(automobileInventory, firstVehicleName);
        System.out.println(returnMessage);
    }
}
