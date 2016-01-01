import java.util.Scanner;

public class Palindrome {
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a number : ");

        try {
            long n = inp.nextLong();
            String yes = "The sum of alternate digits of this number with an odd number of digits is a palindrome.";
            String oddButNotAPalindrome = "The sum of alternate digits of this number with an odd number of digits is not a palindrome.";
            String invalidNumber = "The number does not have an odd number of digits !";

            System.out.print("\n" + ((hasOddNumberOfDigits(n) && isAPalindrome(getSumOfAlternateDigits(n))) ? yes : hasOddNumberOfDigits(n) ? oddButNotAPalindrome : invalidNumber));
            System.out.print("\n\n");
        } catch (Exception e) {
            System.out.print("\nInvalid Input ! \n\n");
        }

    }

    private static boolean isAPalindrome(long n) {
        long backedUpN = n;
        long reversedN = 0;
        long digit;

        while (n > 0) {
            digit = n % 10;
            reversedN = (reversedN * 10) + digit;
            n /= 10;
        }

        return (backedUpN == reversedN);
    }

    private static long getSumOfAlternateDigits(long n) {
        long sum = 0;
        long digit;
        boolean add = true;

        while (n > 0) {
            digit = n % 10;
            sum += (add) ? digit : 0;
            add = !add;
            n /= 10;
        }

        return sum;
    }

    private static boolean hasOddNumberOfDigits(long n) {
        long numberOfDigits = 0;

        while (n > 0) {
            numberOfDigits++;
            n /= 10;
        }

        return ((numberOfDigits % 2) == 1);
    }
}
