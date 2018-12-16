public class LineSegment implements Scalable<LineSegment> {
	protected final double length;

	public LineSegment (double length) {
		this.length = length;
	}

	public LineSegment scale (double scaleFactor) {
		return new LineSegment(length * scaleFactor);
	}

	@Override
	public String toString () {
		return String.format("LineSegment (length = %f)", length);
	}
}
