public class SquareRoot {
	public static void main (String[] args) {
		double n = Double.parseDouble(args[0]);
		int maxIterations = (args.length > 1)? Integer.parseInt(args[1]) : 100;
		
		double root = squareRoot(n, maxIterations);
		double library_root = Math.sqrt(n);

		System.out.printf("Calculated square root     :     %f%n", root);
		System.out.printf("System library square root :     %f%n", library_root);
		System.out.printf("Error : %f%n", (root - library_root));
	}
	
	public static double squareRoot (double n, int maxIterations) {
		if (n < 0)
			return Double.NaN;
		if (n == 0)
			return 0.0;
			
		double x = n / 2;
		for (int i = 0; i < maxIterations; i++) {
			x = 0.5 * (x + (n / x));
		}
		return x;
	}
}
