class PalindromeGenerator {
	public static void main (String[] args) {
		long n = Long.parseLong(args[0]);
		generatePalindrome(n, 0);
	}

	public static void generatePalindrome (long n, int step) {
		long r = reverse(n);
		if (n == r) {
			System.out.printf("%d is a palindrome (%d step%s)%n", n, step, ((step == 1)? "" : "s"));
		} else {
			try {
				long sum = Math.addExact(n, r);
				System.out.printf("%d + %d = %d%n", n, r, sum);
				generatePalindrome(sum, step + 1);
			} catch (ArithmeticException e) {
				System.out.printf("Long Overflow - Sum exceeded maximum size at step %d%n", step);
			}
		}
	}

	public static long reverse (long n) {
		long r = 0;
		while (n > 0) {
			r = (r * 10) + (n % 10);
			n /= 10;
		}
		return r;
	}
}
