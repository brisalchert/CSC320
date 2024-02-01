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
    public static void printTaxWithholding() {
        Scanner input = new Scanner(System.in);
        BigDecimal taxWithholding;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        int income;
        float taxRate;

        System.out.println("Enter weekly income (to nearest dollar):");
        income = input.nextInt();

        // Initialize taxWithholding using income with the cents added on
        taxWithholding = new BigDecimal(income + ".00");
        System.out.println(taxWithholding);
    }

    public static void main(String[] args) {
        printTaxWithholding();
    }
}
