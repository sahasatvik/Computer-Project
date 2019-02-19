public class GameOfLife {
        public boolean[][] board;
        public final int width;
        public final int height;

        public GameOfLife (int width, int height) {
                this.width = width;
                this.height = height;
                board = new boolean [height][width];
                for (int i = 0; i < height; i++)
                        for (int j = 0; j < width; j++)
                                board[i][j] = false;
        }

        public void iterate () {
                boolean[][] newBoard = new boolean[height][width];
                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                                newBoard[i][j] = getNewState(i, j);
                        }
                }
                board = newBoard;
        }

        public boolean getNewState (int i, int j) {
                int n = countNeighbours(i, j);
                return (board[i][j] && ((n == 2) || (n == 3))) || (!board[i][j] && (n == 3));
        }

        public int countNeighbours (int i, int j) {
                i += height;
                j += width;
                int sum = 0;
                sum += board[(i)   % height][(j+1) % width]? 1 : 0;
                sum += board[(i+1) % height][(j+1) % width]? 1 : 0;
                sum += board[(i+1) % height][(j)   % width]? 1 : 0;
                sum += board[(i+1) % height][(j-1) % width]? 1 : 0;
                sum += board[(i)   % height][(j-1) % width]? 1 : 0;
                sum += board[(i-1) % height][(j-1) % width]? 1 : 0;
                sum += board[(i-1) % height][(j)   % width]? 1 : 0;
                sum += board[(i-1) % height][(j+1) % width]? 1 : 0;
                return sum;
        }

        public void showBoard () {
                for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) { 
                                System.out.print(board[i][j]? "██" : "  ");
                        }
                        System.out.println();
                }
        }
}
