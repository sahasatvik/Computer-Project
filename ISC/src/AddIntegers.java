 public class AddIntegers {
 	public static void main (String[] args) {
		int sum = 0;
		for (String num : args) {
			final int n = Integer.parseInt(num);
			System.out.printf("        %32s    (%+11d) %n", binaryString(n), n);
			sum = add(sum, n);
		}
		System.out.printf(" SUM =  %32s    (%+11d) %n", binaryString(sum), sum);
 	}

	public static int add (int a, int b) {
		if (b == 0)
			return a;
		if (a == 0)
			return b;
		final int sum = a ^ b;
		final int carry = a & b;
		return add(sum, carry << 1);
	}

	public static String binaryString (int n) {
		return (n == 0 || n == 1)? (n + "") : (binaryString(n >>> 1) + (n & 1));
	}
 }
