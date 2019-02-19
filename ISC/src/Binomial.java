public class Binomial {
        public static void main (String[] args) {
                try {
                        /* Parse the command line arguments as the terms in the binomial coefficient */
                        long n = Long.parseLong(args[0]);
                        long k = Long.parseLong(args[1]);
                        System.out.println(binomial(n, k));

                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("Enter 2 arguments! ([+integer] [+integer])");
                } catch (Exception e) {
                        System.out.println("Invalid 'k'! (0 <= k <= n)");
                }
        }

        /* Recursively calculate the binomial coefficient n choose k */
        public static long binomial (long n, long k) throws Exception {
                /* Invalid case */
                if (k > n)
                        throw new Exception();
                /* Base case : n choose 0 is 1 */
                if (k == 0)
                        return 1;
                /* Optimisation to reduce the number of recursive steps by reflecting
                   k along the middle of n */
                if (k > (n / 2))
                        return binomial(n, n - k);
                /* Recurse by unfolding the multiplication */
                return (n * binomial(n - 1, k - 1) / k);
        }
}
