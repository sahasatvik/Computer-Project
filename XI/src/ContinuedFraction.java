public class ContinuedFraction {
	public static void main (String[] args) {
		int numerator = Integer.parseInt(args[0]);
		int denominator = Integer.parseInt(args[1]);
		System.out.println(getContinuedFraction(new Fraction(numerator, denominator)));
	}

	public static String getContinuedFraction (Fraction f) {
		String expansion = "[" + getContinuedFraction(f.getNumerator(), f.getDenominator());
		return expansion.replaceFirst(",", ";");
	}

	public static String getContinuedFraction (int numerator, int denominator) {
		if (denominator == 1)
			return numerator + "]";
		return (numerator / denominator) + ", " + getContinuedFraction(denominator, numerator % denominator);
	}
}
