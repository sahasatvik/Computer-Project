public class SortCompare {
        public static void main (String[] args) {
                /* Initialize the sorters */
                IntegerArraySorter[] sorters = {
                        new BubbleSorter(),
                        new InsertionSorter(),
                        new QuickSorter()
                };

                /* Parse the first command line argument as the length of the list */
                int length = Integer.parseInt(args[0]);

                /* Parse the second command line argument as the upper bound of integers in the list */
                int range = Integer.parseInt(args[1]);

                /* Create a random list */
                int[] a = randomArray(length, range);

                long t0 = 0, t1 = 0;
                for (IntegerArraySorter s : sorters) {
                        /* Clone the list */
                        int[] b = a.clone();

                        /* Start the timer */
                        t0 = System.nanoTime();

                        /* Sort */
                        s.sort(b);

                        /* Stop the timer */
                        t1 = System.nanoTime();

                        System.out.printf("%16s : %16d ns\n", s, t1 - t0);
                }
        }

        /* Generates a random array of given length and given upper limit of random numbers */
        public static int[] randomArray (int length, int hi) {
                int[] a = new int[length];
                for (int i = 0; i < length; i++)
                        a[i] = (int) (Math.random() * hi);
                return a;
        }
}
