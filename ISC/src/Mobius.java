public class Mobius {
	public static final String[] graph = 
		{"*        ",
		 "    *    ",
		 "        *"};
	public static void main (String[] args) {
		try {
			int lo = Integer.parseInt(args[0]);
			int hi = Integer.parseInt(args[1]);
			if (lo < 1 || hi <= lo)
				throw new NumberFormatException();
			for (int i = lo; i < hi; i++) {
				int m = mobius(i);
				System.out.printf("μ(%d)\t\t =  %2d%24s\n", i, m, graph[m + 1]);
			}
		} catch	(NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("Enter 2 arguments (lower_limit[integer, >0], upper_limit[integer, >lower_limit])!");
		}
	}

	public static int mobius (int n) {
		if (n < 1)
			return 0;
		if (n == 1)
			return 1;
		int mob = 1;
		for (int i = 2; i <= n; i++) {
			int multiplicity = 0;
			while ((n % i) == 0) {
				n /= i;
				multiplicity++;
			}
			if (multiplicity == 1) {
				mob = -mob;
			} else if (multiplicity > 1) {
				return 0;
			}
		}
		return mob;
	}
}
