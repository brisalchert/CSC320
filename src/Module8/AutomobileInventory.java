package Module8;

import java.util.HashMap;
import java.util.Scanner;

public class AutomobileInventory {
    public static void main(String[] args) {
        // Initialize automobile inventory
        HashMap<String, Automobile> automobileInventory = new HashMap<>();
        Scanner input = new Scanner(System.in);
        String returnMessage, firstVehicleName, secondVehicleName;
        String[] firstVehicleInfo, secondVehicleInfo;
        Automobile firstVehicle;

        // Create a vehicle using the parameterized constructor
        firstVehicle = new Automobile("Subaru", "Impreza", "Gray", 2018, 56000);

        // Add the first vehicle to the inventory
        firstVehicleName = "Brian's car";
        Automobile.addVehicle(automobileInventory, firstVehicle, firstVehicleName);

        // List the vehicle values
        firstVehicleInfo = Automobile.listVehicleInfo(automobileInventory, firstVehicleName);

        System.out.println("Vehicle Info for " + firstVehicleName + ":");
        System.out.println("------------------------------");

        for (String value : firstVehicleInfo) {
            System.out.println("\t" + value);
        }

        System.out.println();

        // Remove the vehicle and print the return value
        returnMessage = Automobile.removeVehicle(automobileInventory, firstVehicleName);
        System.out.println(returnMessage);

        System.out.println();

        // Add new vehicle to the inventory and print return value
        secondVehicleName = Automobile.getNextVehicleName();
        returnMessage = Automobile.addVehicle(automobileInventory, secondVehicleName);
        System.out.println(returnMessage);

        System.out.println();

        // Print new vehicle information
        secondVehicleInfo = Automobile.listVehicleInfo(automobileInventory, secondVehicleName);

        System.out.println("Vehicle Info for " + secondVehicleName + ":");
        System.out.println("------------------------------");

        for (String value : secondVehicleInfo) {
            System.out.println("\t" + value);
        }

        System.out.println();
    }
}
