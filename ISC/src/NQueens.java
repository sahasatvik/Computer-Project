public class NQueens {
	private final int size;
	public int[] board;
	public int top;
	public int numberOfSolutions;
	public boolean countOnly;

	public NQueens (int size, boolean countOnly) {
		this.size = size;
		this.countOnly = countOnly;
		this.initBoard();
	}

	public void initBoard () {
		this.board = new int[size];
		this.numberOfSolutions = 0;
		this.top = -1;
		for (int i = 0; i < size; i++)
			board[i] = -1;
	}

	public boolean pushQueen (int column) {
		if ((0 <= column) && (column < size) && (top < (size - 1))) {
			board[++top] = column;
			return true;
		}
		return false;
	}

	public int popQueen () {
		if (top >= 0) {
			int t = board[top];
			board[top--] = -1;
			return t;
		}
		return -1;
	}

	public boolean isThreatened (int row) {
		for (int i = 0; i < row; i++) {
			if ((board[row] == board[i]) 
			    || ((board[row] - board[i]) == (row - i)) 
			    || ((board[row] - board[i]) == (i - row))) {
				return true;
			}
		}
		return false;
	}

	public boolean solveNQueens (int row) {
		if (row == size) {
			numberOfSolutions++;
			if (!countOnly) {
				showBoard();
				System.out.println();
			}
			return true;
		}
		for (int i = 0; i < size; i++) {
			pushQueen(i);
			if (!isThreatened(row)) {
				solveNQueens(row + 1);
			}
			popQueen();
		}
		return false;
	}

	public void showBoard () {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(((board[i] == j)? "Q" : "-") + " ");
			}
			System.out.println();
		}
	}

	public static void main (String[] args) {
		int size = Integer.parseInt(args[0]);
		boolean countOnly = Boolean.parseBoolean(args[1]);

		NQueens q = new NQueens(size, countOnly);
		q.solveNQueens(0);
		System.out.println(q.numberOfSolutions);
	}
}
