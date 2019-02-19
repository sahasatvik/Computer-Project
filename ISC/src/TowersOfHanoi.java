public class TowersOfHanoi {
        public static void main (String[] args) {
                try {
                        /* Parse the first command line argument as the number of disks */
                        int disks = Integer.parseInt(args[0]);
                        /* Make sure there is at least one disk */
                        if (disks < 1)
                                throw new NumberFormatException();
                        /* Initiate the recursive steps */
                        solveHanoi(disks, "A", "C", "B");
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        /* Handle missing or incorrectly formatted arguments */
                        System.out.println("Enter 1 argument (number_of_disks[integer, >0])!");
                }
        }

        /* Displays moves to solve the Towers of Hanoi problem with 3 pegs */
        public static void solveHanoi (int disk, String source, String destination, String spare) {
                /* Base case - nothing to do */
                if (disk == 0)
                        return;
                /* Move the stack of (n-1) disks to the spare peg */
                solveHanoi(disk - 1, source, spare, destination);
                /* Move the largest disk to the destination */
                System.out.printf("(%d) : %s -> %s%n", disk, source, destination);
                /* Move the stack of (n-1) disks back on top of the largest
                   disk, on the destination peg */
                solveHanoi(disk - 1, spare, destination, source);
        }
}
