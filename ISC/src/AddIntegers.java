 public class AddIntegers {
 	public static void main (String[] args) {
		int sum = 0;
		for (String num : args) {
			sum = add(sum, Integer.parseInt(num));
		}
		System.out.println(sum);
 	}

	public static int add (int a, int b) {
		if (b == 0)
			return a;
		if (a == 0)
			return b;
		int sum = a ^ b;
		int carry = a & b;
		return add(sum, carry << 1);
	}
 }
