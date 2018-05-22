public class GameOfLifeLauncher {
	public static void main (String[] args) throws Exception {
		GameOfLife g = new GameOfLife(20, 20);

		g.board[1][2] = true;
		g.board[2][3] = true;
		g.board[2][3] = true;
		g.board[3][1] = true;
		g.board[3][2] = true;
		g.board[3][3] = true;
			
		g.showBoard();
		while (true) {
			g.iterate();
			System.out.print("\033[H\033[2J");
			g.showBoard();
			Thread.sleep(300);
		}
	}
}
