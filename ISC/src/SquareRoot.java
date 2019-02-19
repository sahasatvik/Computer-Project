public class SquareRoot {
        public static void main (String[] args) {
                /* Parse the first command line argument as the number to square root */
                double number = Double.parseDouble(args[0]);
                /* Parse the second conmand line argument as the number of iterations.
                   Default to 100 */
                int maxIterations = (args.length > 1)? Integer.parseInt(args[1]) : 100;

                double root = squareRoot(number, maxIterations);
                double library_root = Math.sqrt(number);

                /* Display the calculated root, along with a comparison with the
                   library calculated value */
                System.out.printf("Calculated square root     :     %f%n", root);
                System.out.printf("System library square root :     %f%n", library_root);
                System.out.printf("Error : %f%n", (root - library_root));
        }

        public static double squareRoot (double n, int maxIterations) {
                /* Handle edge cases, ignore negative values */
                if (n < 0)
                        return Double.NaN;
                if (n == 0)
                        return 0.0;
                /* Start by guessing half of the number */
                double x = n / 2;
                for (int i = 0; i < maxIterations; i++) {
                        x = 0.5 * (x + (n / x));
                }
                return x;
        }
}
