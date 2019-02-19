public class BubbleSorter extends IntegerArraySorter {
        @Override
        public void sort (int[] a) {
                int right = a.length;
                boolean swapped = true;
                while (swapped) {
                        swapped = false;
                        for (int i = 1; i < right; i++) {
                                if (a[i - 1] > a[i]) {
                                        swap(a, i - 1, i);
                                        swapped = true;
                                }
                        }
                        right -= 1;
                }
        }

        @Override
        public String toString () {
                return "BubbleSort";
        }
}
