public class Factorize {
        public static void main (String[] args) {
                /* Parse the first command line argument as the number to factorize */
                int number = Integer.parseInt(args[0]);
                /* Start from 2 */
                System.out.println(factorize(number, 2));
        }

        /* Return the String representation of the prime factorization of an integer */
        public static String factorize (int n, int next) {
                /* Base case 1 : nothing to factorize */
                if (n == 1)
                        return "";
                /* Base case 2 : reached a prime */
                if (next >= n)
                        return next + "";
                /* Check for a factor */
                if ((n % next) == 0)
                        return next + " " + factorize(n / next, next);
                /* Recurse by incrementing the next 'factor' to check */
                return factorize(n, next + 1);
        }
}
