public class SieveOfEratosthenes {
	private final int upperLimit;
	private boolean[] primes;

	public SieveOfEratosthenes (int upperLimit) {
		this.upperLimit = upperLimit;
		this.initPrimes();
	}

	public boolean[] getPrimes () {
		return primes;
	}

	public void initPrimes () {
		this.primes = new boolean[upperLimit];
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i < upperLimit; i++)
			primes[i] = true;
	}

	public void sievePrimes () {
		int prime = 2;
		while ((prime * prime) < upperLimit) {
			int multiple = prime * prime;
			while (multiple < upperLimit) {
				primes[multiple] = false;
				multiple += prime;
			}
			while (!primes[++prime]);
		}
	}
} 
