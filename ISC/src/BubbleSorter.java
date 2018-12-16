public class BubbleSorter extends IntegerArraySorter {
	public void sort (int[] a) {
		for (int right = a.length; right > 0; right--)
			for (int i = 1; i < right; i++)
				if (a[i - 1] > a[i])
					swap(a, i - 1, i);
	}

	@Override
	public String toString () {
		return "BubbleSort";
	}
}
