import java.util.Scanner;

public class FractionAdder {
	public static void main (String[] args) {
		Scanner inp = new Scanner(System.in);

		System.out.print("Enter the numerator and denominator [integer integer] of the first fraction  : ");
		Fraction a = new Fraction(inp.nextInt(), inp.nextInt());
		
		System.out.print("Enter the numerator and denominator [integer integer] of the second fraction : ");
		Fraction b = new Fraction(inp.nextInt(), inp.nextInt());

		Fraction sum = Fraction.addFractions(a, b);
		System.out.printf("%n(%s) + (%s) = (%s) %n", a, b, sum);
	}
}
