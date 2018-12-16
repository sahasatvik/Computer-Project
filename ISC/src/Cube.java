public class Cube extends Cuboid {
	public Cube (double side) {
		super(side, side, side);
	}

	public Cube scale (double scaleFactor) {
		return new Cube(length * scaleFactor);
	}

	@Override
	public String toString () {
		return String.format("Cube (side = %f)", length);
	}
}
