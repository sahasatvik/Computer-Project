public class Position {
	private final int x;
	private final int y;

	public Position (int x, int y) {
		this.x = x;
		this.y = y;
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
		int x = this.x + 1;
		String letters = "";
		while (x > 0) {
			letters = (char) ('a' + (--x % 26)) + letters;
			x /= 26;
		}
		return letters + (this.y + 1);
	}
} 
