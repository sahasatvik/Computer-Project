class Unique {
	public static void main (String[] args) {
		try {
			long number = Long.parseLong(args[0]);
			if (isUnique(number)) {
				System.out.println("Unique Number!");
			} else {
				System.out.println("Not a Unique Number!");
			}
		} catch (NumberFormatException e) {
			System.out.println("Enter an integer as the first argument!");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Enter 1 argument (integer)!");
		}
	}
	public static boolean isUnique (long number) {
		int[] count = new int[10];
		String rawNumber = Long.toString(Math.abs(number));
		for (int i = 0; i < rawNumber.length(); i++) {
			int digit = rawNumber.charAt(i) - '0';
			count[digit]++;
			if (count[digit] > 1) {
				return false;
			}
		}
		return true;
	}
} 
