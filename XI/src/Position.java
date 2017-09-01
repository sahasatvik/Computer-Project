public class Position {
	private final int x;
	private final int y;

	/* Initialize using the coordinates on the board */
	public Position (int x, int y) {
		this.x = x;
		this.y = y;
	}

	/* Initialize using the position in algebraic notation */
	public Position (String s) {
		int x = 0;
		int i = 0;
		while (i < s.length() && Character.isAlphabetic(s.charAt(i))) {
			x = (x * 26) + Character.toLowerCase(s.charAt(i)) - 'a' + 1;
			i++;
		}
		int y = Integer.parseInt(s.substring(i));
		this.x = x - 1;
		this.y = y - 1;
	}

	public int getX () {
		return x;
	}

	public int getY () {
		return y;
	}

	public boolean equals (Position p) {
		return (p != null) 
			&& (this.getX() == p.getX()) && (this.getY() == p.getY());
	}
	
	@Override
	public String toString () {
		return xToString(this.x) + (this.y + 1);
	}
	
	/* Convert a rank number to its algebraic notation form */
	public static String xToString (int n) {
		int x = n + 1;
		String letters = "";
		while (x > 0) {
			letters = (char) ('a' + (--x % 26)) + letters;
			x /= 26;
		}
		return letters;
	}
} 
