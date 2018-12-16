public class Square extends Rectangle {
	public Square (double side) {
		super(side, side);
	}

	public Square scale (double scaleFactor) {
		return new Square(length * scaleFactor);
	}

	@Override
	public String toString () {
		return String.format("Square (side = %f)", length);
	}
}
