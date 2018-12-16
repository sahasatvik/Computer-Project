public class SortCompare {
	public static void main (String[] args) {
		IntegerArraySorter[] sorters = {
			new BubbleSorter(),
			new InsertionSorter(),
			new QuickSorter()
		};
		
		int[] a = randomArray(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		// System.out.println(toString(a));
		
		long t0 = 0, t1 = 0;
		for (IntegerArraySorter s : sorters) {
			int[] b = a.clone();
			t0 = System.nanoTime();
			s.sort(b);
			t1 = System.nanoTime();
			System.out.printf("%16s : %16d ns\n", s, t1 - t0);
			// System.out.println(toString(b));
		}
	}

	public static String toString (int[] a) {
		if (a.length == 0)
			return "[]";
		String s = "";
		for (int n : a)
			s += n + ", ";
		return "[" + s.substring(0, s.length() - 2) + "]";
	}

	public static int[] randomArray (int length, int hi) {
		int[] a = new int[length];
		for (int i = 0; i < length; i++)
			a[i] = (int) (Math.random() * hi);
		return a;
	}
}
