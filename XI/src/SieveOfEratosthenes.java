public class SieveOfEratosthenes {
	private final int upperLimit;
	private boolean[] primes;
	
	/* Initialize the list of numbers using an uper limit */
	public SieveOfEratosthenes (int upperLimit) {
		this.upperLimit = upperLimit;
		this.initPrimes();
	}

	public boolean[] getPrimes () {
		return primes;
	}

	/* Initialize all value to 'prime' by default */
	public void initPrimes () {
		this.primes = new boolean[upperLimit];
		/* Mark known values as 'not prime' */
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i < upperLimit; i++)
			primes[i] = true;
	}

	/* Iteratively sieve the numbers to leave primes behind */
	public void sievePrimes () {
		/* Start with the first prime */
		int prime = 2;
		while ((prime * prime) < upperLimit) {
			/* Start with the first multiple not crossed off */
			int multiple = prime * prime;
			while (multiple < upperLimit) {
				/* Cross multiples of a prime off the list */
				primes[multiple] = false;
				multiple += prime;
			}
			/* Skip forward to the next prime */
			while (!primes[++prime]);
		}
	}
} 
