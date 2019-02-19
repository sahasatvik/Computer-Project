public class ClosedKnightTours {
        public static void main (String[] args) {
                try {
                        final int boardSize = Integer.parseInt(args[0]);
                        if (boardSize <= 0)
                                throw new NumberFormatException();
                        final String initSquare = (args.length > 1)? args[1] : "a1";
                        final double randomness = (args.length > 2)? Double.parseDouble(args[2])
                                : Math.pow(0.8, boardSize) * 2;
                        for (int i = 0; i < Integer.parseInt(args[3]); i++) {
                                new Thread (
                                                new Runnable() {
                                                public void run () {
                                                Position[] solution = new TourSolver(boardSize, new Position(initSquare), randomness).getSolution();
                                                if (ClosedKnightTours.isClosed(solution)) {
                                                ClosedKnightTours.showMoves(solution);
                                                }
                                                }
                                                }
                                           ).start();
                        }
                } catch (Exception e) {
                        System.out.println("Syntax : java ClosedKnightTours [boardSize] [initSquare] [randomness] [numberOfThreads]");
                }
        }

        public static synchronized void showMoves (Position[] moves) {
                System.out.print("\nMoves : ");
                String movesOut = "";
                for (int i = 1; i < moves.length; i++) {
                        movesOut += (moves[i-1] + "-" + moves[i] + ", ");
                }
                System.out.println(movesOut.substring(0, movesOut.length() - 2));
        }

        public static String multiplyString (String s, int n) {
                String result = "";
                while (n --> 0)
                        result += s;
                return result;
        }

        public static boolean isClosed (Position[] path) {
                int l = path.length - 1;
                int dX = Math.abs(path[0].getX() - path[l].getX());
                int dY = Math.abs(path[0].getY() - path[l].getY());
                return (dX == 1 && dY == 2) || (dX == 2 && dY == 1);
        }
} 
