class KnightTour {
	public static void main (String[] args) {
		TourSolver t = new TourSolver(Integer.parseInt(args[0]), new Position(args[1]));
		Position[] solution = t.getSolution();
		showBoard(t.getBoard());
		if (isClosed(solution))
			System.out.println("\nThe tour is Closed!");
		showMoves(solution);
	}

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
		for (int i = 0; i < board.length; i++){
			System.out.printf("  %2s  ", Position.xToString(i));
		}
		System.out.println();
	}

	public static void showMoves (Position[] moves) {
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
