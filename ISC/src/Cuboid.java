public class Cuboid implements Shape3D, Scalable<Cuboid> {
	protected final double length;
	protected final double breadth;
	protected final double height;

	public Cuboid (double length, double breadth, double height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}

	public double getVolume () {
		return length * breadth * height;
	}

	public double getSurfaceArea () {
		return 2.0 * ((length * breadth) + (breadth * height) + (height * length));
	}

	public Cuboid scale (double scaleFactor) {
		return new Cuboid(length * scaleFactor, breadth * scaleFactor, height * scaleFactor);
	}

	@Override
	public String toString () {
		return String.format("Cuboid (length = %f, breadth = %f, height = %f)", length, breadth, height);
	}
}
