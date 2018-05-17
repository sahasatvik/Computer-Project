public class Fraction {

	/* Store the numerator and denominator */
	protected int numerator;
	protected int denominator;

	public Fraction (int numerator, int denominator) {
		/* Handle invalid fractions */
		if (denominator == 0)
			throw new ArithmeticException("Division by zero!");
		
		this.numerator = Math.abs(numerator);
		this.denominator = Math.abs(denominator);

		if (numerator != 0) {
			/* Reduce to lowest terms */
			int g = gcd(this.numerator, this.denominator);
			this.numerator /= g;
			this.denominator /= g;
			/* Make sure that the sign is on the numerator */
			this.numerator *= Math.signum(numerator) * Math.signum(denominator);
		} else {
			/* Make sure all 'zero fractions' are the same */
			this.denominator = 1;
		}
	}

	public int getNumerator () {
		return this.numerator;
	}

	public int getDenominator () {
		return this.denominator;
	}
	
	/* Return a String representation of the Fraction for display */
	public String toString () {
		/* Format all fractions with denominator '1' as simple integers */
		if (this.denominator == 1)
			return this.numerator + "";
		return this.numerator + " / " + this.denominator;
	}
	
	/* Add 2 Fraction objects */
	public static Fraction addFractions (Fraction a, Fraction b) {
		int sumNumerator = (a.getNumerator() * b.getDenominator()) + (a.getDenominator() * b.getNumerator());
		int sumDenominator = a.getDenominator() * b.getDenominator();
		return new Fraction(sumNumerator, sumDenominator);
	}
	
	/* Calculate the greatest common divisor of integers, using Euclid's method recursively */
	private static int gcd (int p, int q) {
		return (p < q)? gcd(q, p) : ((p % q) == 0)? q : gcd(q, p % q);
	}
}
