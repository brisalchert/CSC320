//----------------------------------------------------------------------------------------------------------------------
//  Option #2: Capture Grade Statistics Using For-loop
//  --------------------------------------------------
//  Write a program that will provide important statistics for the grades in a class. The program will utilize a
//  for-loop to read ten floating-point grades from user input. Include code to prevent an endless loop. Ask the user
//  to enter the values, then print the following data:
//
//  - Average
//  - Maximum
//  - Minimum
//----------------------------------------------------------------------------------------------------------------------

package Module4;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CriticalThinking3 {
    /**
     * Gets ten floating-point grades from the user and outputs the average, maximum, and minimum.
     */
    public static void getGradeStatistics() {
        Scanner input = new Scanner(System.in);
        float average;
        float sum = 0;
        int gradeCount = 0;
        float maximum = Float.MIN_VALUE;
        float minimum = Float.MAX_VALUE;
        DecimalFormat twoDecimalPlaces = new DecimalFormat("#.00");

        for (int count = 1; count <= 10; count++) {
            float currentGrade = -1;

            // Prompt the user for a grade:
            System.out.print("Enter a floating-point value for a grade: ");

            // Continue prompting the user for a grade until a valid value is entered
            do {
                try {
                    currentGrade = input.nextFloat();

                    // If the grade is negative, request new input
                    if (currentGrade < 0) {
                        System.out.print("Invalid input. Please enter again: ");
                    }
                }
                // If the input is not a float, request new input
                catch (InputMismatchException error) {
                    System.out.print("Invalid input. Please enter again: ");
                    // Skip the invalid input
                    input.next();
                }
            } while (currentGrade < 0);

            // Add the current grade to the sum
            sum += currentGrade;

            gradeCount++;

            // Check if the current grade is the new maximum
            if (currentGrade > maximum) {
                maximum = currentGrade;
            }

            // Check if the current grade is the new minimum
            if (currentGrade < minimum) {
                minimum = currentGrade;
            }
        }

        System.out.println();

        // Calculate the average
        average = sum / gradeCount;

        // Print the results
        System.out.println("Grade Statistics:");
        System.out.println("-----------------");
        System.out.println("Average: " + twoDecimalPlaces.format(average));
        System.out.println("Maximum: " + twoDecimalPlaces.format(maximum));
        System.out.println("Minimum: " + twoDecimalPlaces.format(minimum));
    }

    public static void main(String[] args) {
        getGradeStatistics();
    }
}
