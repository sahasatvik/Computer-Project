public class NQueens {
	private final int size;
	private int[] board;
	private int numberOfSolutions;
	private final boolean drawSolutions;
	
	/* Sets the size of the board and the number of queens */
	public NQueens (int size, boolean drawSolutions) {
		this.size = size;
		this.drawSolutions = drawSolutions;
		this.initBoard();
	}
	
	/* Returns the number of solutions to a board of given size */
	public int countSolutions () {
		solveNQueens(0);
		return numberOfSolutions;
	}
	
	/* Initializes the board */
	private void initBoard () {
		this.board = new int[size];
		this.numberOfSolutions = 0;
		for (int i = 0; i < size; i++)
			board[i] = -1;
	}
	
	/* Determines whether the queen on a specified row is threatened
	   by a queen on a previous row */
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
	
	/* Recursively solves the n-queens problem */
	private void solveNQueens (int row) {
		if (row == size) {
			/* Reached maximum recursion depth - found a solution */
			numberOfSolutions++;
			if (drawSolutions) {
				drawBoard();
				System.out.println();
			}
			return;
		}
		/* Place queens on all possible columns on the row */
		for (board[row] = 0; board[row] < size; board[row]++) {
			if (!isThreatened(row)) {
				/* Recurse if the board is valid so far */
				solveNQueens(row + 1);
			}
		}
	}
	
	/* Displays the current configuration of the board */
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
			/* Parse the first command line argument as the size of the board */
			int size = Integer.parseInt(args[0]);
			/* Parse the second command line argument as a boolean, indicating
			   whether to draw the solved boards. Defaults to not showing the solutions */
			boolean drawSolutions = (args.length > 1)? Boolean.parseBoolean(args[1]) : false;
			/* Make sure the board exists */
			if (size < 1)
				throw new NumberFormatException();
			/* Create a 'NQueens' object */
			NQueens q = new NQueens(size, drawSolutions);
			/* Display the number of solutions */
			System.out.println(q.countSolutions());
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			/* Handle missing or incorrectly formatted arguments */
			System.out.println("Enter at least 1 argument (size_of_board[integer], <show_solutions>[true/false])!");
			System.out.println("(show_solutions defaults to false)");
		}
	}
}
