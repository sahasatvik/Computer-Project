public class GameOfLifeLauncher {
	public static void main (String[] args) throws Exception {
		GameOfLife g = new GameOfLife(32, 32);

		g.board[1][2] = true;
		g.board[2][3] = true;
		g.board[3][1] = true;
		g.board[3][2] = true;
		g.board[3][3] = true;
		
		g.board[10][11] = true;
		g.board[11][12] = true;
		g.board[12][10] = true;
		g.board[12][11] = true;
		g.board[12][12] = true;
				
		g.board[20][21] = true;
		g.board[21][22] = true;
		g.board[22][20] = true;
		g.board[22][21] = true;
		g.board[22][22] = true;
		
		g.showBoard();
		while (true) {
			g.iterate();
			System.out.print("\033[H\033[2J");
			g.showBoard();
			Thread.sleep(300);
		}
	}
}
