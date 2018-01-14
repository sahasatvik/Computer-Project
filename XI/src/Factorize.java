public class Factorize {
	public static void main (String[] args) {
		int number = Integer.parseInt(args[0]);
		System.out.println(factorize(number, 2));
	}

	public static String factorize (int n, int next) {
		if (n == 1)
			return "";
		else if (next >= n)
			return next + "";
		else if ((n % next) == 0)
			return next + " " + factorize(n / next, next);
		
		return factorize(n, next + 1);
	}
}
