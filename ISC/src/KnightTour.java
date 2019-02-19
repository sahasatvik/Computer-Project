public class KnightTour {
        public static void main (String[] args) {
                try {
                        /* Parse the first command line argument as the size of the board */
                        int boardSize = Integer.parseInt(args[0]);
                        if (boardSize <= 0)
                                throw new NumberFormatException();
                        /* Parse the second command line argument as the starting square
                           of the knight, written in algebraic notation */
                        String initSquare = (args.length > 1)? args[1] : "a1";
                        /* Parse the third command line argument as the degree of
                           randomness to be used while resolving ties */
                        double randomness = (args.length > 2)? Double.parseDouble(args[2])
                                : Math.pow(0.8, boardSize) * 2;
                        /* Create an object capable of solving knight's tours */
                        TourSolver t = new TourSolver(boardSize, new Position(initSquare), randomness);
                        Position[] solution = t.getSolution();
                        if (solution != null) {
                                showBoard(t.getBoard());
                                showMoves(solution);
                                if (isClosed(solution))
                                        System.out.println("\nThe tour is Closed!");
                        } else {
                                System.out.println("No Knight's Tours found!");
                        }
                } catch (Exception e) {
                        /* Handle missing or incorrectly formatted arguments */
                        System.out.print("Enter an integer (> 1) as the first argument, ");
                        System.out.println("and a well formed chessboard coordinate as the second!");
                        System.out.println("                                 (size, startSquare * , randomness * )");
                        System.out.println();
                        System.out.println("(size          -> Solve a Tour on a (size x size) board)");
                        System.out.println("(startSquare * -> A square in algebraic chess notation of the form 'fr',");
                        System.out.println("                  where f = the letter representing the file(column)");
                        System.out.println("                  and   r = the number representing the rank(row).)");
                        System.out.println("(startSquare is set to 'a1' by default)");
                        System.out.println("(randomness *  -> A number between 0(no randomness) and 1(even chances),");
                        System.out.println("                  determining the randomness in ranking positions of");
                        System.out.println("                  the same weightage while searching. A randomness of 0 will");
                        System.out.println("                  produce the same tour every time, for a specific size and");
                        System.out.println("                  startSquare. Keep extremely small values of randomness for");
                        System.out.println("                  very large boards.)");
                        System.out.println("(randomness is set to 2 * (0.8)^boardSize by default)");
                        System.out.println();
                        System.out.println("                                                  < * = optional arguments >");
                }
        }

        /* Display the board, with each square marked with the move number on which
           the knight landed on it */
        public static void showBoard (int[][] board) {
                String hLine = "    " + multiplyString("+-----", board.length) + "+";
                System.out.println(hLine);
                for (int column = board.length - 1; column >= 0; column--) {
                        System.out.printf(" %2d ", column + 1);
                        for (int row = 0; row < board.length; row++) {
                                System.out.printf("| %3d ", board[row][column]);
                        }
                        System.out.printf("|%n%s%n", hLine);
                }
                System.out.print("   ");
                for (int i = 0; i < board.length; i++) {
                        System.out.printf("  %2s  ", Position.xToString(i));
                }
                System.out.println();
        }

        /* Display the list of moves in the tour in algebraic notation */
        public static void showMoves (Position[] moves) {
                System.out.print("\nMoves : ");
                String movesOut = "";
                for (int i = 1; i < moves.length; i++) {
                        movesOut += (moves[i-1] + "-" + moves[i] + ", ");
                }
                System.out.println(movesOut.substring(0, movesOut.length() - 2));
        }

        /* Utility function for repeating strings */
        public static String multiplyString (String s, int n) {
                String result = "";
                while (n --> 0)
                        result += s;
                return result;
        }

        /* Check whether a tour is closed or not */
        public static boolean isClosed (Position[] path) {
                int l = path.length - 1;
                int dX = Math.abs(path[0].getX() - path[l].getX());
                int dY = Math.abs(path[0].getY() - path[l].getY());
                return (dX == 1 && dY == 2) || (dX == 2 && dY == 1);
        }
} 
