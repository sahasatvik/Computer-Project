public class Partition {
        public static void main (String[] args) {
                try {
                        /* Parse the first command line argument as the target sum */
                        int target = Integer.parseInt(args[0]);
                        if (target < 1) {
                                throw new NumberFormatException();
                        }
                        partition(target);
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        /* Handle missing or incorrectly formatted arguments */
                        System.out.println("Enter 1 argument (number[natural number])!");
                }
        }

        /* Wrapper method for displaying partitions of a number */
        public static void partition (int target) {
                partition(target, target, "");
        }

        /* Display the partitions of the target */
        public static void partition (int target, int previousTerm, String suffix) {
                /* Base case : '0' has no partitions */
                if (target == 0)
                        System.out.println(suffix);
                /* Recursively solve for partitions by diminishing the target,
                   adding that difference to the solution, and partitioning the
                   remaining sum */
                for (int i = 1; i <= target && i <= previousTerm; i++)
                        partition(target - i, i, suffix + " " + i);
        }
} 
