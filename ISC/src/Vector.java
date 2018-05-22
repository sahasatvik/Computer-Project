public class Vector {
	private final int dimension;
	private final double[] components;
	
	public Vector (double ... components) {
		this.dimension = components.length;
		this.components = new double[dimension];
		for (int i = 0; i < dimension; i++)
			this.components[i] = components[i];
	}

	public int getDimension () {
		return this.dimension;
	}

	public double getComponent (int index) {
		return this.components[index - 1];
	}

	public double getAbsoluteValue () {
		double abs = 0.0;
		for (int i = 0; i < dimension; i++)
			abs += (components[i] * components[i]);
		return Math.sqrt(abs);
	}

	public Vector add (Vector v) {
		return Vector.add(this, v);
	}

	public Vector dotProduct (Vector v) {
		return Vector.dotProduct(this, v);
	}

	public double angleBetween (Vector v) {
		return Vector.angleBetween(this, v);
	}

	@Override
	public String toString () {
		String s = "(";
		for (int i = 0; i < dimension; i++)
			s += components[i] + ", ";
		return s.replaceAll(", $", ")");
	}
	
	public static Vector multiplyByScalar (Vector v, double l) {
		double[] t = new double[v.getDimension()];
		for (int i = 0; i < t.length; i++)
			t[i] = v.getComponent(i+1) * l;
		return new Vector(t);
			
	}

	public static Vector add (Vector a, Vector b) {
		double[] sum = new double[a.getDimension()];
		for (int i = 0; i < sum.length; i++)
			sum[i] = a.getComponent(i+1) + b.getComponent(i+1);
		return new Vector(sum);
	}

	public static Vector add (Vector ... vectors) {
		Vector v = vectors[0];
		for (int i = 1; i < vectors.length; i++)
			v = Vector.add(v, vectors[i]);
		return v;
	}

	public static Vector dotProduct (Vector a, Vector b) {
		double[] dotProduct = new double[a.getDimension()];
		for (int i = 0; i < dotProduct.length; i++)
			dotProduct[i] = a.getComponent(i+1) * b.getComponent(i+1);
		return new Vector(dotProduct);
	}
	
	public static Vector dotProduct (Vector ... vectors) {
		Vector v = vectors[0];
		for (int i = 1; i < vectors.length; i++)
			v = Vector.dotProduct(v, vectors[i]);
		return v;
	}

	public static double angleBetween (Vector a, Vector b) {
		return Math.acos(Vector.dotProduct(a, b).getAbsoluteValue() / (a.getAbsoluteValue() * b.getAbsoluteValue()));
	}
}
