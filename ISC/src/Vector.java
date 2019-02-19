public class Vector {
        /* Vector data is immutable */
        protected final int dimension;
        protected final double[] components;

        /* Use varargs to create an arbitrary dimensional vector */
        public Vector (double ... components) {
                this.dimension = components.length;
                this.components = new double[dimension];
                for (int i = 0; i < dimension; i++)
                        this.components[i] = components[i];
        }

        /* Returns the dimensionality of the vector */
        public int getDimension () {
                return this.dimension;
        }

        /* Returns the component at the specified index.
           This uses indexing starting at '1' per mathematical convention */
        public double getComponent (int index) {
                return this.components[index - 1];
        }

        /* Returns the absolute value/magnitude of the vector */
        public double getAbsoluteValue () {
                double abs = 0.0;
                for (int i = 0; i < dimension; i++)
                        abs += (components[i] * components[i]);
                return Math.sqrt(abs);
        }

        /* Wrapper methods which call static ones */

        public Vector multiplyByScalar (double k) {
                return Vector.multiplyByScalar(this, k);
        }

        public Vector add (Vector v) {
                return Vector.add(this, v);
        }

        public double dotProduct (Vector v) {
                return Vector.dotProduct(this, v);
        }

        public double angleBetween (Vector v) {
                return Vector.angleBetween(this, v);
        }

        public boolean equals (Vector v) {
                return Vector.equals(this, v);
        }

        /* Format vector components neatly */
        @Override
        public String toString () {
                String s = "(";
                for (double component : components)
                        s += component + ", ";
                return s.replaceAll(", $", ")");
        }

        /* Checks for equality between two vectors */
        public static boolean equals (Vector a, Vector b) {
                /* Dimensionalities must be equal */
                if (a.getDimension() != b.getDimension())
                        return false;
                /* Corresponding components must be equal */
                for (int i = 1; i <= a.getDimension(); i++)
                        if (a.getComponent(i) != b.getComponent(i))
                                return false;
                return true;
        }

        /* Multiplies a vector by a scalar to return a vector */
        public static Vector multiplyByScalar (Vector v, double k) {
                double[] t = new double[v.getDimension()];
                for (int i = 0; i < t.length; i++)
                        t[i] = v.getComponent(i+1) * k;
                return new Vector(t);
        }

        /* Adds two vectors to return a vector */
        public static Vector add (Vector a, Vector b) {
                double[] sum = new double[a.getDimension()];
                /* Add corresponding components */
                for (int i = 0; i < sum.length; i++)
                        sum[i] = a.getComponent(i+1) + b.getComponent(i+1);
                return new Vector(sum);
        }

        /* Adds multiple vectors to return a vector */
        public static Vector add (Vector ... vectors) {
                Vector v = vectors[0];
                /* Repeatedly use the binary addition method */
                for (int i = 1; i < vectors.length; i++)
                        v = Vector.add(v, vectors[i]);
                return v;
        }

        /* Returns the dot product of two vectors */
        public static double dotProduct (Vector a, Vector b) {
                double dotProduct = 0.0;
                /* Multiply corresponding components */
                for (int i = 1; i <= a.getDimension(); i++)
                        dotProduct += a.getComponent(i) * b.getComponent(i);
                return dotProduct;
        }

        /* Returns the angle between two vectors in radians.
           If 'u' and 'v' are vectors, with an angle 'A' between them,
           u.v = |u||v| cos(A)  */
        public static double angleBetween (Vector a, Vector b) {
                return Math.acos(Vector.dotProduct(a, b) / (a.getAbsoluteValue() * b.getAbsoluteValue()));
        }
}
