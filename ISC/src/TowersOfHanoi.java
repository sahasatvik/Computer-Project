public class TowersOfHanoi {
	public static void main (String[] args) {
		try {
			int disks = Integer.parseInt(args[0]);
			if (disks < 1)
				throw new NumberFormatException();
			solveHanoi(disks, "A", "B", "C");
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("Enter 1 argument (number_of_disks[integer])!");
		}
	}

	public static void solveHanoi (int disk, String source, String destination, String spare) {
		if (disk == 0)
			return;
		solveHanoi(disk - 1, source, spare, destination);
		System.out.printf("(%d) : %s -> %s%n", disk, source, destination);
		solveHanoi(disk - 1, spare, destination, source);
	}
}
