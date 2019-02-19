class PalindromeGenerator {
        public static void main (String[] args) {
                /* Parse the first command line argument as the seed */
                long n = Long.parseLong(args[0]);
                generatePalindrome(n, 0);
        }

        public static void generatePalindrome (long n, int step) {
                long r = reverse(n);
                if (n == r) {
                        /* Base case : palindrome reached */
                        System.out.printf("%d is a palindrome (%d step%s)%n", n, step, ((step == 1)? "" : "s"));
                } else {
                        try {
                                /* Use a library method to add. This will throw an
                                   Exception in case of overflow, which would have
                                   otherwise been ignored */
                                long sum = Math.addExact(n, r);
                                System.out.printf("%d + %d = %d%n", n, r, sum);
                                /* Recurse via tail recursion, simply incrementing the step value */
                                generatePalindrome(sum, step + 1);
                        } catch (ArithmeticException e) {
                                /* Stop if the numbers become too big */
                                System.out.printf("Long Overflow - Sum exceeded maximum size at step %d%n", step);
                        }
                }
        }

        /* Reverse the integer supplied */
        public static long reverse (long n) {
                long r = 0;
                while (n > 0) {
                        /* Pull out the last digit and accumulate it on another variable */
                        r = (r * 10) + (n % 10);
                        n /= 10;
                }
                return r;
        }
}
