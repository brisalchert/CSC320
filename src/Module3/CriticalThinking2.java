//----------------------------------------------------------------------------------------------------------------------
//  Option #1: Calculate Average Withholding
//  ----------------------------------------
//  Create a program that will calculate the weekly average tax withholding for a customer given the following weekly
//  income guidelines:
//
//  - Income less than $500: tax rate 10%
//  - Incomes greater than/equal to $500 and less than $1500: tax rate 15%
//  - Incomes greater than/equal to $1500 and less than $2500: tax rate 20%
//  - Incomes greater than/equal to $2500: tax rate 30%
//----------------------------------------------------------------------------------------------------------------------

package Module2;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class CriticalThinking2 {
    /**
     * Prompts the user for their weekly income and then calculates and prints their tax withholding.
     */
    public static void printTaxWithholding() {
        Scanner input = new Scanner(System.in);
        BigDecimal taxWithholding, income, taxRate;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

        System.out.println("Enter weekly income (to nearest dollar):");
        income = BigDecimal.valueOf(input.nextInt());

        // Check if the income is valid (positive)
        if (income.intValue() < 0) {
            System.out.println("Invalid income.");

            return;
        }

        // Get taxRate based on income
        taxRate = getTaxRate(income);

        // Set taxWithholding using income and taxRate
        taxWithholding = income.multiply(taxRate);

        // Return information to the user
        System.out.println("Your tax withholding is " + currencyFormatter.format(taxWithholding) + ".");
    }

    /**
     * Gets the specified tax rate based on the entered income.
     * @param income the user's income as a BigDecimal
     * @return the tax rate as a BigDecimal
     */
    public static BigDecimal getTaxRate(BigDecimal income) {
        if (income.intValue() < 500) {
            return BigDecimal.valueOf(0.1);
        }

        if (income.intValue() < 1500) {
            return BigDecimal.valueOf(0.15);
        }

        if (income.intValue() < 2500) {
            return BigDecimal.valueOf(0.2);
        }

        return BigDecimal.valueOf(0.3);
    }

    public static void main(String[] args) {
        printTaxWithholding();
    }
}
