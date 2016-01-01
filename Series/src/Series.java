import java.util.Scanner;

public class Series {
    public static void main(String args[]) {

        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a number from the menu below : " +
                "\n   " +
                "\n1. Display the series 0, 3, 8, 15, 24, ... n" +
                "\n2. Display the sum of the series 1/2, 3/4, 5/6, ... 19/20" +
                "\n " +
                "\nChoice : ");

        try {
            int choice = inp.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter the number of terms required : ");
                    System.out.print("\n" + series(inp.nextInt()));
                    break;
                case 2:
                    System.out.print("\nThe sum of the given series is : " + sum());
                    break;
                default:
                    System.out.print("\nWrong choice !");
            }
        } catch (Exception e) {
            System.out.print("\nWrong Choice !");
        }

        System.out.print("\n\n");

    }

    private static String series(int n) {
        String series = "";

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                series += (i * i) - 1;
                series += (i != n) ? ", " : "\n";
            }
        } else {
            series = "Invalid number.\nPlease enter a number greater than 0.\n";
        }

        return series;
    }

    private static double sum() {

        double sum = 0.0;

        for (double i = 1.0; i <= 19.0; i += 2.0) {
            sum += i / (i + 1.0);
        }

        return sum;
    }
}
