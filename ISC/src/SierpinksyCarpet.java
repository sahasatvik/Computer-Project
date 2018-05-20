public class SierpinksyCarpet {
	public static void main (String[] args) {
		int level = Integer.parseInt(args[0]);

		for (int i = 0; i < Math.pow(3, level); i++) {
			for (int j = 0; j < Math.pow(3, level); j++) {
				System.out.print(isInSierpinksyCarpet(i, j)? "██" : "  ");
			}
			System.out.println();
		}
	}

	public static boolean isInSierpinksyCarpet (int x, int y) {
		if (Math.min(x, y) == 0)
			return true;
		if (((x % 3) == 1) && ((y % 3) == 1))
			return false;
		return isInSierpinksyCarpet(x / 3, y / 3);
	}
}
