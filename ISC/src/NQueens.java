public class NQueens {
	private final int size;
	private int[] board;
	private int numberOfSolutions;
	private final boolean drawSolutions;

	public NQueens (int size, boolean drawSolutions) {
		this.size = size;
		this.drawSolutions = drawSolutions;
		this.initBoard();
	}

	public int countSolutions () {
		solveNQueens(0);
		return numberOfSolutions;
	}

	private void initBoard () {
		this.board = new int[size];
		this.numberOfSolutions = 0;
		for (int i = 0; i < size; i++)
			board[i] = -1;
	}

	private boolean isThreatened (int row) {
		for (int i = 0; i < row; i++) {
			if ((board[row] == board[i]) 
			    || ((board[row] - board[i]) == (row - i)) 
			    || ((board[row] - board[i]) == (i - row))) {
				return true;
			}
		}
		return false;
	}

	private void solveNQueens (int row) {
		if (row == size) {
			numberOfSolutions++;
			if (drawSolutions) {
				drawBoard();
				System.out.println();
			}
			return;
		}
		for (board[row] = 0; board[row] < size; board[row]++) {
			if (!isThreatened(row)) {
				solveNQueens(row + 1);
			}
		}
	}

	public void drawBoard () {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(((board[i] == j)? "Q" : "-") + " ");
			}
			System.out.println();
		}
	}

	public static void main (String[] args) {
		try {
			int size = Integer.parseInt(args[0]);
			boolean drawSolutions = (args.length > 1)? Boolean.parseBoolean(args[1]) : false;
			if (size < 1)
				throw new NumberFormatException();

			NQueens q = new NQueens(size, drawSolutions);
			System.out.println(q.countSolutions());
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("Enter at least 1 argument (size_of_board[integer], <show_solutions>[true/false])!");
			System.out.println("(show_solutions defaults to false)");
		}
	}
}
