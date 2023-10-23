import java.util.Scanner;   // Needed for Scanner class
public class CalculateTax3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // declare variables
        double income;
        int taxCategory;
        double tax;
        // get user input
        System.out.print("Enter your income: ");
        income = in.nextDouble();
        System.out.print("(0-single filer, 1-married jointly or qualifying widow(er), "
                       + "\n2-married separately, 3-head of household)\n" +
                "Enter the filing status: ");
        taxCategory = in.nextInt();
        // print tax category
        printTaxCategory(taxCategory);
        // calculate tax
        if (taxCategory == 0) {
            tax = calcIncomeTax(income, 10275, 41775, 89075, 170050, 215950, 539900);
        } else if (taxCategory == 1) {
            tax = calcIncomeTax(income, 20550, 83550, 178150, 340100, 431900, 647850);
        } else if (taxCategory == 2) {
            tax = calcIncomeTax(income, 10275, 41775, 89075, 170050, 215950, 323925);
        } else if (taxCategory == 3) {
            tax = calcIncomeTax(income, 14650, 55900, 89050, 170050, 215950, 539900);
        } else {
            tax = 0;
        }
        // print tax
        System.out.printf("Tax is $%.2f\n", tax);
    }

    public static void printTaxCategory(int statusCode) {
        switch (statusCode) {
            case 0:
                System.out.println("Single");
                break;
            case 1:
                System.out.println("Married Filing Jointly or Qualifying Widow(er)");
                break;
            case 2:
                System.out.println("Married Filing Separately");
                break;
            case 3:
                System.out.println("Head of Household");
                break;
            default:
                // exit program
                System.exit(1);
        }
    }

    private static double calcIncomeTax(double income, double... bounds) {
        if (income <= bounds[0]) {
            return income * 0.10;
        } else if (income <= bounds[1]) {
            return bounds[0] * 0.10 + (income - bounds[0]) * 0.12;
        } else if (income <= bounds[2]) {
            return bounds[0] * 0.10 + (bounds[1] - bounds[0]) * 0.12 + (income - bounds[1]) * 0.22;
        } else if (income <= bounds[3]) {
            return bounds[0] * 0.10 + (bounds[1] - bounds[0]) * 0.12 + (bounds[2] - bounds[1]) * 0.22 + (income - bounds[2]) * 0.24;
        } else if (income <= bounds[4]) {
            return bounds[0] * 0.10 + (bounds[1] - bounds[0]) * 0.12 + (bounds[2] - bounds[1]) * 0.22 + (bounds[3] - bounds[2]) * 0.24 + (income - bounds[3]) * 0.32;
        } else if (income <= bounds[5]) {
            return bounds[0] * 0.10 + (bounds[1] - bounds[0]) * 0.12 + (bounds[2] - bounds[1]) * 0.22 + (bounds[3] - bounds[2]) * 0.24 + (bounds[4] - bounds[3]) * 0.32 + (income - bounds[4]) * 0.35;
        } else {
            return bounds[0] * 0.10 + (bounds[1] - bounds[0]) * 0.12 + (bounds[2] - bounds[1]) * 0.22 + (bounds[3] - bounds[2]) * 0.24 + (bounds[4] - bounds[3]) * 0.32 + (bounds[5] - bounds[4]) * 0.35 + (income - bounds[5]) * 0.37;
        }
    }
}
