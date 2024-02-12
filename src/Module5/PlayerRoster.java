package Module5;

import java.util.Scanner;

public class PlayerRoster {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int count = 5;
        int[] jerseys = new int[count];
        int[] ratings = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Enter player " + (i + 1) + "'s jersey number:");
            jerseys[i] = scnr.nextInt();
            System.out.println("Enter player " + (i + 1) + "'s rating:");
            ratings[i] = scnr.nextInt();
            System.out.println();
        }

        outputRoster(jerseys, ratings);

        printMenu(scnr, jerseys, ratings);
    }

    public static void printMenu(Scanner input, int[] jerseys, int[] ratings) {
        System.out.println();
        System.out.println("MENU");
        System.out.println("u - Update player rating");
        System.out.println("a - Output players above a rating");
        System.out.println("r - Replace player");
        System.out.println("o - Output roster");
        System.out.println("q - Quit");
        System.out.println();
        System.out.println("Choose an option:");

        getMenuOption(input, input.next().charAt(0), jerseys, ratings);
    }

    public static void getMenuOption(Scanner input, char userInput, int[] jerseys, int[] ratings) {
        switch (userInput) {
            case 'u':
                updateRating(input, jerseys, ratings);
                break;
            case 'a':
                outputPlayersAbove(input, jerseys, ratings);
                break;
            case 'r':
                replacePlayer(input, jerseys, ratings);
                break;
            case 'o':
                outputRoster(jerseys, ratings);
                break;
            case 'q':
                return;
            default:
        }

        printMenu(input, jerseys, ratings);
    }

    public static void outputRoster(int[] jerseys, int[] ratings) {
        System.out.println("ROSTER");
        for (int i = 0; i < jerseys.length; i++) {
            System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseys[i] + ", Rating: " + ratings[i]);
        }
    }

    public static void updateRating(Scanner input, int[] jerseys, int[] ratings) {
        System.out.println("Enter a jersey number:");
        int jersey = input.nextInt();
        System.out.println("Enter a new rating for player:");
        int rating = input.nextInt();
        int index = 0;
        for (int i = 0; i < jerseys.length; i++) {
            if (jerseys[i] == jersey) {
                index = i;
            }
        }
        ratings[index] = rating;
    }

    public static void outputPlayersAbove(Scanner input, int[] jerseys, int[] ratings) {
        System.out.println("Enter a rating:");
        int rating = input.nextInt();

        System.out.println("ABOVE " + rating);
        for (int i = 0; i < jerseys.length; i++) {
            if (ratings[i] > rating) {
                System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseys[i] + ", Rating: " + ratings[i]);
            }
        }
    }

    public static void replacePlayer(Scanner input, int[] jerseys, int[] ratings) {
        System.out.println("Enter a jersey number:");
        int oldJersey = input.nextInt();
        System.out.println("Enter a new jersey number:");
        int newJersey = input.nextInt();
        System.out.println("Enter a rating for the new player:");
        int rating = input.nextInt();
        int index = 0;
        for (int i = 0; i < jerseys.length; i++) {
            if (jerseys[i] == oldJersey) {
                index = i;
            }
        }
        jerseys[index] = newJersey;
        ratings[index] = rating;
    }
}
