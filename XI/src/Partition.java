
class Partition {
	public static void main (String[] args) {
		try {
			int n = Integer.parseInt(args[0]);
			if (n < 1) {
				throw new NumberFormatException();
			}
			partition(n);
		} catch (NumberFormatException e) {
			System.out.println("Enter a natural number as the first argument!");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Enter 1 argument (natural number)!");
		}
	}
	public static void partition (int n) {
		partition(n, n, "");
	}
	public static void partition (int target, int previousTerm, String suffix) {
		if (target == 0)
			System.out.println(suffix);
		for (int i = 1; i <= target && i <= previousTerm; i++)
			partition(target - i, i, suffix + " " + i);
	}
} 
