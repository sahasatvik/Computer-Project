public class Sphere implements Shape3D, Scalable<Sphere> {
	protected final double radius;

	public Sphere (double radius) {
		this.radius = radius;
	}

	public double getVolume () {
		return 4.0 * Math.PI * radius * radius * radius / 3.0;
	}

	public double getSurfaceArea () {
		return 4 * Math.PI * radius * radius;
	}

	public Sphere scale (double scaleFactor) {
		return new Sphere(radius * scaleFactor);
	}

	@Override
	public String toString () {
		return String.format("Sphere (radius = %f)", radius);
	}
}
