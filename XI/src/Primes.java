public class Primes {
	public static void main (String[] args) {
		try {
			/* Parse the first command line argument as the upper limit
			   on primes to calculate */
			int upperLimit = Integer.parseInt(args[0]);
			if (upperLimit < 2) {
				throw new NumberFormatException();
			}
			SieveOfEratosthenes sieve = new SieveOfEratosthenes(upperLimit);
			sieve.sievePrimes();
			showPrimes(sieve.getPrimes());
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			/* Handle missing or incorrectly formatted arguments */
			System.out.println("Enter 1 argument (limit[integer, >1])!");
			System.out.println("(Primes will be dislayed up to, not including 'limit')");
		}	
	}

	/* Display all primes calculated */
	public static void showPrimes (boolean[] primes) {
		int primeCount = 0;
		/* Format all number to the same width */
		int maxLength = Integer.toString(primes.length).length();
		for (int i = 0; i < primes.length; i++) {
			/* If 'i' is prime, primes[i] will be marked 'true' */
			if (primes[i]) {
				System.out.printf("%" + maxLength + "d ", i);
				primeCount++;
			}
		}
		System.out.println("\nTotal number of primes : " + primeCount);
	}
} 
