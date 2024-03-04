//----------------------------------------------------------------------------------------------------------------------
//  AutomobileInventory.java
//
//  Driver class for Automobile.java. We create a HashMap automobile inventory and execute various methods from the
//  Automobile class in order to verify their functionality.
//----------------------------------------------------------------------------------------------------------------------

package Module8;

import java.util.HashMap;
import java.util.Scanner;

public class AutomobileInventory {
    public static void main(String[] args) {
        // Initialize automobile inventory
        HashMap<String, Automobile> automobileInventory = new HashMap<>();
        String returnMessage, firstVehicleName, secondVehicleName;
        Automobile firstVehicle;

        // Create a vehicle using the parameterized constructor
        firstVehicle = new Automobile("Subaru", "Impreza", "Gray", 2018, 56000);

        // Add the first vehicle to the inventory
        firstVehicleName = "Brian's car";
        Automobile.addVehicle(automobileInventory, firstVehicle, firstVehicleName);

        // List the vehicle values
        Automobile.printVehicleInfo(automobileInventory, firstVehicleName);

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
        Automobile.printVehicleInfo(automobileInventory, secondVehicleName);

        // Update second vehicle's info
        returnMessage = Automobile.updateVehicle(automobileInventory, secondVehicleName);
        System.out.println(returnMessage);

        System.out.println();

        // Print updated vehicle information
        Automobile.printVehicleInfo(automobileInventory, secondVehicleName);
    }


}
