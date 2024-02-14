//----------------------------------------------------------------------------------------------------------------------
//  Option #1: Get Weekly Temperatures
//  ----------------------------------
//  Develop a Java program that will store data in the form of daily average temperatures for one week. Store the day
//  and average temperature in two different arraylists. Your program should prompt the user for the day of the week
//  (Monday through Sunday) and display both the day and temperature for each day. If "week" is entered, the output
//  for your program should provide the temperature for each day and the weekly average. Use the looping and decision
//  constructs in combination with the arrays to complete this assignment.
//----------------------------------------------------------------------------------------------------------------------

package Module5;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CriticalThinking4 {
    public static ArrayList<String> weekdays;
    public static ArrayList<Double> weeklyTemperatures;

    public static void getTemperatureReadings() {
        // Initialize the ArrayLists
        initializeArrayLists();

        Scanner input = new Scanner(System.in);
        String userInput;

        // Prompt the user for a day of the week
        System.out.print("Enter a day of the week (\"q\" to quit, \"week\" for the whole week): ");
        userInput = input.next();

        // Repeat until the user enters the sentinel value to quit
        while (!userInput.equals("q")) {
            int dayIndex = weekdays.indexOf(userInput);

            // If the input was invalid, inform the user and go to the next iteration
            if (dayIndex == -1) {
                System.out.println("Invalid input.");
                System.out.println();
                System.out.print("Enter a day of the week (\"q\" to quit, \"week\" for the whole week): ");
                userInput = input.next();
                continue;
            }

            // Get the temperature for the given day
            getDailyTemperature(dayIndex);
            System.out.println();

            // Prompt the user for new input
            System.out.print("Enter a day of the week (\"q\" to quit, \"week\" for the whole week): ");
            userInput = input.next();
        }
    }

    public static void initializeArrayLists() {
        Random generator = new Random();

        // Initialize ArrayLists
        weekdays = new ArrayList<>();
        weeklyTemperatures = new ArrayList<>();

        // Add all the weekdays
        weekdays.add("Monday");
        weekdays.add("Tuesday");
        weekdays.add("Wednesday");
        weekdays.add("Thursday");
        weekdays.add("Friday");
        weekdays.add("Saturday");
        weekdays.add("Sunday");

        // Add random weekly temperatures in the range 20.0 - 50.0 Fahrenheit
        for (int index = 0; index < weekdays.size(); index++) {
            // Generate random int from 0 to 300, divide by (double) 10.0, then add 20 to get temp in proper range
            weeklyTemperatures.add((generator.nextInt(300) / 10.0) + 20);
        }
    }

    private static void getDailyTemperature(int dayIndex) {
        System.out.println("Temperature for " + weekdays.get(dayIndex) + ": "
                           + weeklyTemperatures.get(dayIndex) + " degrees Fahrenheit.");
    }

    private static double getAverageWeeklyTemperature() {
        double sum = 0;

        for (double temperature : weeklyTemperatures) {
            sum += temperature;
        }

        return (sum / weeklyTemperatures.size());
    }

    public static void main(String[] args) {
        getTemperatureReadings();
    }
}
