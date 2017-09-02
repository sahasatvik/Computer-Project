public class TourSolver {
	private final int size;
	private Position[] path;
	private int numberOfMoves;
	private int[][] board;
	private int[][] degreesOfFreedom;
	private Position initPosition;
	private	double tieBreakRandomness;

	/* Store the list of possible changes in the 'x' and 'y' coordinates of
	   a knight on an empty board */
	private static final int[][] KNIGHT_MOVES = {
		{-1, -2}, {-1, 2}, {1, -2}, {1, 2},
		{-2, -1}, {-2, 1}, {2, -1}, {2, 1}
	};

	/* Initialize the board and move stack */
	public TourSolver (int size, Position initPosition, double randomness) {
		this.size = size;
		this.initPosition = initPosition;
		this.tieBreakRandomness = randomness / 2.0;
		this.path = new Position[size * size];
		this.numberOfMoves = 0;
		this.initBoard();
		this.initDegreesOfFreedom();
	}
	
	/* Reset the board */
	public void resetSolution () {
		this.path = new Position[size * size];
		this.numberOfMoves = 0;
		this.initBoard();
	}

	/* Initialize a blank board */
	private void initBoard () {
		board = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				board[i][j] = 0;
	}

	/* Calculate the mobility of a knight on each square */
	private void initDegreesOfFreedom () {
		degreesOfFreedom = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				degreesOfFreedom[i][j] = getPossibleMovesCount(new Position(i, j));
	}

	/* Push a move onto the move stack, add it to the board */
	public boolean addMove (Position p) {
		if (numberOfMoves < (size * size)) {
			path[numberOfMoves++] = p;
			board[p.getX()][p.getY()] = numberOfMoves;
			return true;
		}
		return false;
	}

	/* Pop a move from the move stack, remove it from the board */
	public boolean removeMove () {
		if (numberOfMoves > 0) {
			Position p = path[numberOfMoves - 1];
			/* Empty squares are marked '0' */
			board[p.getX()][p.getY()] = 0;
			path[--numberOfMoves] = null;
			return true;
		}
		return false;
	}

	public int[][] getBoard () {
		return board;
	}
	
	/* Get the stack of moves comprising a knight's tour */
	public Position[] getSolution () {
		if (size < 5)
			return null;
		addMove(initPosition);
		if(solve(initPosition))
			return path;
		return null;
	}
	
	/* Recursively solve a tour from a given position */
	public boolean solve (Position p) {
		/* If the move stack is full, the tour has been solved */
		if (numberOfMoves  == (size * size))
			return true;
		/* Get every legal move and rank them using Warnsdorf's Rule */
		Position[] possibleMoves = getPossibleMoves(p);
		if (possibleMoves[0] == null)
			return false;
		sortMoves(possibleMoves);
		for (Position move : possibleMoves) {
			if (move != null) {
				/* Try a move */
				addMove(move);
				if (solve(move))
					return true;
				/* Backtrack */
				removeMove();
			}
		}
		return false;
	}

	/* Sort a list of positions using Warnsdorf's Rule */
	public void sortMoves (Position[] moves) {
		int count = 0;
		for (Position p : moves)
			if (p != null)
				count++;
		for (int right = count; right > 0; right--)
			for (int i = 1; i < right; i++)
				if (compareMoves(moves[i-1], moves[i]) > 0)
					swapMoves(i-1, i, moves);
	}
	
	/* Compare 2 moves using Warnsdorf's Rule */
	public int compareMoves (Position a, Position b) {
		/* Compare the mobilities of the knight */
		int aCount = getPossibleMovesCount(a);
		int bCount = getPossibleMovesCount(b);
		if (aCount != bCount)
			return aCount - bCount;
		/* Compare the mobilities of the knight on an empty board */
		int aFree = degreesOfFreedom[a.getX()][a.getY()];
		int bFree = degreesOfFreedom[b.getX()][b.getY()];
		if (aFree != bFree)
			return aFree - bFree;
		/* Resolve ties using a predecided element of randomness */
		return (Math.random() < tieBreakRandomness)? 1 : -1;
	}

	/* Utility function to swap moves in the list of possible moves */
	private static void swapMoves (int x, int y, Position[] moves) {
		Position t = moves[x];
		moves[x] = moves[y];
		moves[y] = t;
	}
	
	/* Get the list of all possible, legal moves not touching a previously
	   travelled square from a given position */
	public Position[] getPossibleMoves (Position start) {
		Position[] possibleMoves = new Position[KNIGHT_MOVES.length];
		int i = 0;
		for (int[] move : KNIGHT_MOVES) {
			/* Generate a new */
			int x = start.getX() + move[0];
			int y = start.getY() + move[1];
			/* Check the legality of that move */
			if (isWithinBoard(x, y) && board[x][y] == 0) {
				possibleMoves[i++] = new Position(x, y);
			}
		}
		return possibleMoves;
	}

	/* Get the number of legal moves */
	public int getPossibleMovesCount (Position start) {
		int i = 0;
		for (Position p : getPossibleMoves(start))
			if (p != null)
				i++;
		return i;
	}
	
	/* Check whether a position lies within the board */
	public boolean isWithinBoard (int x, int y) {
		return (x >= 0 && x < size && y >= 0 && y < size);
	}
} 
