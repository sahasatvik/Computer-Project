public class QuickSorter extends IntegerArraySorter {
	public void sort (int[] a) {
		sort(a, 0, a.length - 1);
	}

	private void sort (int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int pivot = partition(a, lo, hi);
		sort(a, lo, pivot - 1);
		sort(a, pivot + 1, hi);
	}

	private int partition (int[] a, int lo, int hi) {
		int pivotValue = a[hi];
		int pivot = lo - 1;
		for (int i = lo; i < hi; i++)
			if (a[i] <= pivotValue)
				swap(a, i, ++pivot);
		swap(a, hi, ++pivot);
		return pivot;
	}

	@Override
	public String toString () {
		return "QuickSort";
	}
}
