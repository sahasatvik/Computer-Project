public class Unique {
	public static void main (String[] args) {
		try {
			/* Parse the first command line argument as the number
			   to check for unique digits */
			long number = Long.parseLong(args[0]);
			if (isUnique(number)) {
				System.out.println("Unique Number!");
			} else {
				System.out.println("Not a Unique Number!");
			}
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			/* Handle missing or incorrectly formatted arguments */
			System.out.println("Enter 1 argument (number[integer])!");
		}
	}

	public static boolean isUnique (long number) {
		/* Keep track of the number of occurrences of each digit */
		int[] count = new int[10];
		for (long n = Math.abs(number); n > 0; n /= 10) {
			/* Extract the last digit of the number */
			int digit = (int) n % 10;
			count[digit]++;
			if (count[digit] > 1){
				return false;
			}
		}
		return true;
	}
} 
