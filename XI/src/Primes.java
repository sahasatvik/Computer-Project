public class Primes {
	public static void main (String[] args) {
		try {
			int upperLimit = Integer.parseInt(args[0]);
			if (upperLimit < 2) {
				throw new NumberFormatException();
			}
			SieveOfEratosthenes sieve = new SieveOfEratosthenes(upperLimit);
			sieve.sievePrimes();
			showPrimes(sieve.getPrimes());
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("Enter 1 argument (limit[integer, >1])!");
			System.out.println("(Primes will be dislayed up to, not including 'limit')");
		}	
	}

	public static void showPrimes (boolean[] primes) {
		int primeCount = 0;
		int maxLength = Integer.toString(primes.length).length();
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.printf("%" + maxLength + "d ", i);
				primeCount++;
			}
		}
		System.out.println("\nTotal number of primes : " + primeCount);
	}
} 
