public class Rectangle implements Shape2D, Scalable<Rectangle> {
	protected final double length;
	protected final double breadth;

	public Rectangle (double length, double breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	public double getArea () {
		return length * breadth;
	}

	public double getPerimeter () {
		return 2 * (length + breadth);
	}

	public Rectangle scale (double scaleFactor) {
		return new Rectangle(length * scaleFactor, breadth * scaleFactor);
	}

	@Override
	public String toString () {
		return String.format("Rectangle (length = %f, breadth = %f)", length, breadth);
	}
}
