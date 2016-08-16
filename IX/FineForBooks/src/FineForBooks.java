import java.util.Scanner;

public class FineForBooks {
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        System.out.print("\n\nEnter the number of days the book is overdue : ");
        try {
            int daysOverdue = inp.nextInt();
            double fine;

            if (daysOverdue >= 0) {
                if (daysOverdue <= 5) {
                    fine = daysOverdue * 45.0 / 100.0;
                } else if (daysOverdue <= 10) {
                    fine = (5 * 45.0 / 100.0) + ((daysOverdue - 5) * 65.0 / 100.0);
                } else {
                    fine = (5 * 45.0 / 100.0) + (5 * 65.0 / 100.0) + ((daysOverdue - 10) * 85.0 / 100.0);
                }

                System.out.format("\nTotal fine incurred = \tRs. %.2f \n\n", fine);
            } else {
                System.out.print("\nInvalid Number !\n\n");
            }
        } catch (Exception e) {
            System.out.print("\nInvalid Input ! \n\n");
        }

    }
}
