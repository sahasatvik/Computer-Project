
public class Partition {
	public static void main (String[] args) {
		try {
			int target = Integer.parseInt(args[0]);
			if (target < 1) {
				throw new NumberFormatException();
			}
			partition(target);
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("Enter 1 argument (number[natural number])!");
		}
	}
	public static void partition (int target) {
		partition(target, target, "");
	}
	public static void partition (int target, int previousTerm, String suffix) {
		if (target == 0)
			System.out.println(suffix);
		for (int i = 1; i <= target && i <= previousTerm; i++)
			partition(target - i, i, suffix + " " + i);
	}
} 
