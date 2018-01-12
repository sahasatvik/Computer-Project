public class Fraction {
	protected int numerator;
	protected int denominator;

	public Fraction (int numerator, int denominator) {
		if (denominator == 0)
			throw new ArithmeticException("Division by zero!");
		
		this.numerator = Math.abs(numerator);
		this.denominator = Math.abs(denominator);

		if (numerator != 0) {
			int g = gcd(this.numerator, this.denominator);
			this.numerator /= g;
			this.denominator /= g;
			this.numerator *= Math.signum(numerator) * Math.signum(denominator);
		} else {
			this.denominator = 1;
		}
	}

	public int getNumerator () {
		return this.numerator;
	}

	public int getDenominator () {
		return this.denominator;
	}

	public String toString () {
		if (this.denominator == 1)
			return this.numerator + "";
		return this.numerator + " / " + this.denominator;
	}
	
	public static Fraction addFractions (Fraction a, Fraction b) {
		int sumNumerator = (a.getNumerator() * b.getDenominator()) + (a.getDenominator() * b.getNumerator());
		int sumDenominator = a.getDenominator() * b.getDenominator();
		return new Fraction(sumNumerator, sumDenominator);
	}

	private static int gcd (int p, int q) {
		return (p < q)? gcd(q, p) : ((p % q) == 0)? q : gcd(q, p % q);
	}
}
