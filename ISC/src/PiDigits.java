public class PiDigits {
	public static final int twoPower = 14;
	public static final int tenPower = 4;
	public static final int tenShift = 10000;
	public static final int initBloc = 2000;

	public static void main (String[] args) {
		int length = Integer.parseInt(args[0]);
		System.out.println(piDigits(length));
	}
	
	public static String piDigits (int length) {
		length = (length * twoPower) / tenPower;
		StringBuffer pi = new StringBuffer();
		int[] digits = new int[length + 1];
		int carry = 0;

		for (int i = 0; i <= length; i++)
			digits[i] = initBloc;

		for (int i = length; i > 0; i -= twoPower) {
			int sum = 0;
			for (int j = i; j > 0; j--) {
				sum = (sum * j) + (tenShift * digits[j]);
				digits[j] = sum % ((j * 2) - 1);
				sum /= (j * 2) - 1;
			}
			pi.append(String.format("%0" + tenPower + "d", carry + (sum / tenShift)));
			carry = sum % tenShift;
		}

		return pi.toString();
	}
}
