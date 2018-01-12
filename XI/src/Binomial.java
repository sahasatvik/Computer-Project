public class Binomial {
	public static void main (String[] args) {
		try {
			long n = Long.parseLong(args[0]);
			long k = Long.parseLong(args[1]);
			System.out.println(binomial(n, k));

		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Invalid 'k'! (0 <= k <= n)");
		}
	}

	public static long binomial (long n, long k) throws Exception {
		if (k > n)
			throw new Exception();
		if (k == 0)
			return 1;
		if (k > (n / 2))
			return binomial(n, n - k);
		return (n * binomial(n - 1, k - 1) / k);
	}
}
