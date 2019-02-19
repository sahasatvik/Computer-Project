public class SierpinskiCarpet {
        public static void main (String[] args) {
                try {
                        /* Parse the first command line argument as the level of detail of the carpet */
                        int level = Integer.parseInt(args[0]);
                        /* Make sure that the level is positive */
                        if (level < 0)
                                throw new NumberFormatException();
                        /* Iterate over every 'point' in the carpet */
                        for (int i = 0; i < Math.pow(3, level); i++) {
                                for (int j = 0; j < Math.pow(3, level); j++) {
                                        /* Display a full block for points 'in' the carpet */
                                        System.out.print(isInSierpinskiCarpet(i, j)? "\u2588\u2588" : "  ");
                                }
                                System.out.println();
                        }
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        /* Handle missing or incorrectly formatted arguments */
                        System.out.println("Enter 1 argument (order_of_carpet[integer])!");
                }
        }

        /* Determines whether a point is in the carpet */
        public static boolean isInSierpinskiCarpet (int x, int y) {
                /* Blocks are in the carpet if they are on the edge */
                if (x == 0 || y == 0)
                        return true;
                /* Blocks at the centres of 3-by-3 squares on any level are
                   not in the carpet */
                if (((x % 3) == 1) && ((y % 3) == 1))
                        return false;
                /* Recurse to the next, larger level */
                return isInSierpinskiCarpet(x / 3, y / 3);
        }
}
