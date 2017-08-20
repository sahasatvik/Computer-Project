public class TourSolver {
	private final int size;
	private Position[] path;
	private int numberOfMoves;

	private int[][] board;
	private int[][] degreesOfFreedom;

	private Position initPosition;
	
	private static final int[][] KNIGHT_MOVES = {
		{-1, -2}, {-1, 2}, {1, -2}, {1, 2},
		{-2, -1}, {-2, 1}, {2, -1}, {2, 1}
	};

	public TourSolver (int size, Position initPosition) {
		this.size = size;
		this.initPosition = initPosition;
		this.path = new Position[size * size];
		this.numberOfMoves = 0;
		initBoard();
		initDegreesOfFreedom();
	}

	private void initBoard () {
		board = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				board[i][j] = 0;
	}

	private void initDegreesOfFreedom () {
		degreesOfFreedom = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				degreesOfFreedom[i][j] = getPossibleMovesCount(new Position(i, j));
	}

	public boolean addMove (Position p) {
		if (numberOfMoves < (size * size)) {
			path[numberOfMoves++] = p;
			board[p.getX()][p.getY()] = numberOfMoves;
			return true;
		}
		return false;
	}

	public boolean removeMove () {
		if (numberOfMoves > 0) {
			Position p = path[numberOfMoves - 1];
			board[p.getX()][p.getY()] = 0;
			path[--numberOfMoves] = null;
			return true;
		}
		return false;
	}

	public int[][] getBoard () {
		return board;
	}
	
	public Position[] getSolution () {
		if (size < 5)
			return null;
		addMove(initPosition);
		if(solve(initPosition))
			return path;
		return null;
	}
	
	public boolean solve (Position p) {
		if (numberOfMoves  == (size * size))
			return true;
		Position[] possibleMoves = getPossibleMoves(p);
		if (possibleMoves[0] == null)
			return false;
		sortMoves(possibleMoves);
		for (Position move : possibleMoves) {
			if (move != null) {
				addMove(move);
				if (solve(move))
					return true;
				removeMove();
			}
		}
		return false;
	}

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
	
	public int compareMoves (Position a, Position b) {
		int aCount = getPossibleMovesCount(a);
		int bCount = getPossibleMovesCount(b);
		if (aCount != bCount)
			return aCount - bCount;
		int aFree = degreesOfFreedom[a.getX()][a.getY()];
		int bFree = degreesOfFreedom[b.getX()][b.getY()];
		if (aFree != bFree)
			return aFree - bFree;
		return (Math.random() < 0.5)? 1 : -1;
	}

	private static void swapMoves (int x, int y, Position[] moves) {
		Position t = moves[x];
		moves[x] = moves[y];
		moves[y] = t;
	}

	public Position[] getPossibleMoves (Position start) {
		Position[] possibleMoves = new Position[KNIGHT_MOVES.length];
		int i = 0;
		for (int[] move : KNIGHT_MOVES) {
			int x = start.getX() + move[0];
			int y = start.getY() + move[1];
			if (isWithinBoard(x, y) && board[x][y] == 0) {
				possibleMoves[i++] = new Position(x, y);
			}
		}
		return possibleMoves;
	}

	public int getPossibleMovesCount (Position start) {
		int i = 0;
		for (Position p : getPossibleMoves(start))
			if (p != null)
				i++;
		return i;
	}
	
	public boolean isWithinBoard (int x, int y) {
		return (x >= 0 && x < size && y >= 0 && y < size);
	}
} 
