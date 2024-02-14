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

public class CriticalThinking4 {
    public static void getTemperatureReadings() {
        Random generator = new Random();
        ArrayList<String> weekdays = new ArrayList<>();
        ArrayList<Double> weeklyTemperatures = new ArrayList<>();

        // Add all the weekdays (lowercase so that input can be case-insensitive by setting it to lowercase)
        weekdays.add("monday");
        weekdays.add("tuesday");
        weekdays.add("wednesday");
        weekdays.add("thursday");
        weekdays.add("friday");
        weekdays.add("saturday");
        weekdays.add("sunday");

        // Add random weekly temperatures in the range 20.0 - 50.0 Fahrenheit
        for (int index = 0; index < weekdays.size(); index++) {
            // Generate random int from 0 to 300, divide by (double) 10.0, then add 20 to get temp in proper range
            weeklyTemperatures.add((generator.nextInt(300) / 10.0) + 20);
        }
    }

    public static void main(String[] args) {
        getTemperatureReadings();
    }
}
