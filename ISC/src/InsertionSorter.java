public class InsertionSorter extends IntegerArraySorter {
        @Override
        public void sort (int[] a) {
                for (int i = 1; i < a.length; i++) {
                        int k = a[i];
                        int j = i - 1;
                        while ((j >= 0) && (a[j] > k)) {
                                a[j + 1] = a[j];
                                j -= 1;
                        }
                        a[j + 1] = k;
                }
        }

        @Override
        public String toString () {
                return "InsertionSort";
        }
}
