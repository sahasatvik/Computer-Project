public class TourSolver {
	private final int size;
	private Position[] path;
	private int numberOfMoves;

	private int[][] board;

	private static final int[][] KNIGHT_MOVES = {
		{-1, -2}, {-1, 2}, {1, -2}, {1, 2},
		{-2, -1}, {-2, 1}, {2, -1}, {2, 1}
	};

	public TourSolver (int size, Position initPosition) {
		this.size = size;
		path = new Position[size * size];
		board = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				board[i][j] = 0;
		numberOfMoves = 0;
		addMove(initPosition);
		solve(initPosition);
	}

	public Position[] getSolution () {
		return path;
	}

	public boolean addMove (Position p) {
		if (numberOfMoves < (size * size)) {
			path[numberOfMoves++] = p;
			board[p.getX()][p.getY()] = 1;
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

	public boolean solve (Position p) {
		if (numberOfMoves  == (size * size)) {
			return true;
		}
		Position[] possibleMoves = getPossibleMoves(p, path);
		if (possibleMoves[0] == null) {
			return false;
		}
		for (Position move : possibleMoves) {
			if (move != null) {
				addMove(move);
				if (solve(move)) {
					return true;
				} else {
					removeMove();
				}
			}
		}
		return false;
	}
	
	
	public Position[] getPossibleMoves (Position start, Position[] forbidden) {
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
	
	/*	
	public Position[] getPossibleMoves (Position start, Position[] forbidden) {
		Position[] possibleMoves = new Position[KNIGHT_MOVES.length];
		int i = 0;
		for (int[] move : KNIGHT_MOVES) {
			int x = start.getX() + move[0];
			int y = start.getY() + move[1];
			if (isWithinBoard(x, y)) {
				Position possible = new Position(x, y);
				if (!containsPosition(possible, forbidden)) {
					possibleMoves[i++] = possible;
				}
			}
		}
		return possibleMoves;
	}
	*/

	public boolean containsPosition (Position pos, Position[] list) {
		for (Position candidate : list) {
			if (candidate != null && pos.equals(candidate)) {
				return true;
			}
		}
		return false;
	}

	public int getSize () {
		return size;
	}

	public boolean isWithinBoard (int x, int y) {
		return (x >= 0 && x < size && y >= 0 && y < size);
	}
} 
