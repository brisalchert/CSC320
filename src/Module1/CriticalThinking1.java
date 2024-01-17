//----------------------------------------------------------------------------------------------------------------------
//  Option #1: List Individual's Name and Address Information
//  Demonstrate understanding of basic programming concepts by:
//
//  Develop pseudocode that prints the following information for a fictional person:
//    - First name
//    - Last name
//    - Street address
//    - City
//    - Zip code
//
//  Create a simple java application that will print the items listed above on individual lines.
//----------------------------------------------------------------------------------------------------------------------

package Module1;

import java.util.Scanner;

public class CriticalThinking1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstName, lastName, streetAddress, city;
        int zipCode;

        // Take user input
        System.out.print("Enter First Name: ");
        firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        lastName = input.nextLine();

        System.out.print("Enter Street Address: ");
        streetAddress = input.nextLine();

        System.out.print("Enter City Name: ");
        city = input.nextLine();

        System.out.print("Enter Zip Code: ");
        zipCode = input.nextInt();

        System.out.println();

        // Output personal information:
        System.out.println("Personal Information:");
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(streetAddress);
        System.out.println(city);
        System.out.println(zipCode);
    }
}
