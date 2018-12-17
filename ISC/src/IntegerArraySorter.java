/* Abstract integer array sorter */
public abstract class IntegerArraySorter {
	/* Each sorter has a common sort method */
	public abstract void sort (int[] a);

	/* Utility method for swapping elements in an array */
	public static void swap (int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
