class KnightTour {
	public static void main (String[] args) {
		TourSolver t = new TourSolver(Integer.parseInt(args[0]), new Position(0, 0));
		Position[] solution = t.getSolution();
		
		String moves = "";
		for (int i = 1; i < solution.length; i++) {
			moves += (solution[i-1] + "-" + solution[i] + ",\n");
		}
		System.out.print(moves.substring(0, moves.length() - 2));
	}
} 
