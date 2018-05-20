public class TowersOfHanoi {
	public static void main (String[] args) {
		int disks = Integer.parseInt(args[0]);
		solveHanoi(disks, "A", "B", "C");
	}

	public static void solveHanoi (int disk, String source, String destination, String spare) {
		if (disk == 0)
			return;
		solveHanoi(disk - 1, source, spare, destination);
		System.out.printf("(%d) : %s -> %s%n", disk, source, destination);
		solveHanoi(disk - 1, spare, destination, source);
	}
}
