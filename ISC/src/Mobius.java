public class Mobius {
	/* Elements of a basic graph */
	public static final String[] graph = 
		{"*        ",
		 "    *    ",
		 "        *"};
	public static void main (String[] args) {
		try {
			/* Parse the first command line argument as the lower limit */
			int lo = Integer.parseInt(args[0]);
			/* Parse the second commmand line argument as the upper limit */
			int hi = Integer.parseInt(args[1]);
			/* Incorrct input */
			if (lo < 1 || hi <= lo)
				throw new NumberFormatException();
			for (int i = lo; i < hi; i++) {
				int m = mobius(i);
				System.out.printf("μ(%d)\t\t =  %2d%24s\n", i, m, graph[m + 1]);
			}
		} catch	(NumberFormatException | IndexOutOfBoundsException e) {
			/* Handle missing or incorrectly formatted arguments */
			System.out.println("Enter 2 arguments (lower_limit[integer, >0], upper_limit[integer, >lower_limit])!");
		}
	}

	public static int mobius (int n) {
		/* Ignore negative numbers */
		if (n < 1)
			return 0;
		/* Trivial case */
		if (n == 1)
			return 1;
		/* Start with +1 */
		int mob = 1;
		for (int i = 2; i <= n; i++) {
			int multiplicity = 0;
			/* Count the number of times (i) appears */
			while ((n % i) == 0) {
				/* Reduce 'n' */
				n /= i;
				multiplicity++;
			}
			if (multiplicity == 1) {
				/* Flip the sign */
				mob = -mob;
			} else if (multiplicity > 1) {
				/* Squared factor found */
				return 0;
			}
		}
		return mob;
	}
}
