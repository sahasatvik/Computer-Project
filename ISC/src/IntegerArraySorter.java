public abstract class IntegerArraySorter {
	public abstract void sort (int[] a);
	public static void swap (int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
