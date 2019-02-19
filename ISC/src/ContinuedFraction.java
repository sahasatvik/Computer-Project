public class ContinuedFraction {
        public static void main (String[] args) {
                try {
                        /* Parse command line arguments as the numerator and denominator
                           of the fraction */
                        int numerator = Integer.parseInt(args[0]);
                        int denominator = Integer.parseInt(args[1]);
                        System.out.println(getContinuedFraction(new Fraction(numerator, denominator)));
                } catch (ArithmeticException e) {
                        System.out.println("Invalid fraction - division by zero!");
                } catch (Exception e) {
                        System.out.println("Enter 2 arguments! ([numerator] [denominator])");
                }
        }

        /* Return the String representation of the continued fraction */
        public static String getContinuedFraction (Fraction f) {
                String expansion = "[" + getContinuedFraction(f.getNumerator(), f.getDenominator());
                /* By convention, the first comma is replaced with a semicolon */
                return expansion.replaceFirst(",", ";");
        }

        /* Recursively calculate the continued fraction representation */
        public static String getContinuedFraction (int numerator, int denominator) {
                /* Base case : the fraction is now irreducible */
                if (denominator == 1)
                        return numerator + "]";
                /* Pull out the integer part, invert the fraction and recurse */
                return (numerator / denominator) + ", " + getContinuedFraction(denominator, numerator % denominator);
        }
}
