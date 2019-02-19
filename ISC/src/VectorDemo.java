public class VectorDemo {
        public static void main (String[] args) {
                /* Simple 2D vector with magnitude sqrt(2) */
                Vector a = new Vector(1, 1);
                System.out.printf("Magnitude of %s is %f\n", a, a.getAbsoluteValue());

                /* Create 3 random 3D vectors */
                Vector b = new Vector(random(-10, 10), random(-10, 10), random(-10, 10));
                Vector c = new Vector(random(-10, 10), random(-10, 10), random(-10, 10));
                Vector d = new Vector(random(-10, 10), random(-10, 10), random(-10, 10));

                /* Demonstrate addition, dot products, angle measurement */
                System.out.printf("Sum of vectors %s, %s, %s is %s\n", b, c, d, Vector.add(b, c, d));
                System.out.printf("Dot product of %s and %s is %d\n", b, c, (int) Vector.dotProduct(b, c));
                System.out.printf("The angle between %s and %s is %f degrees\n", b, c, 
                                Math.toDegrees(Vector.angleBetween(b, c)));
        }

        /* Returns random integers in a specified range */
        public static int random (int lo, int hi) {
                return (int) (lo + ((hi - lo) * Math.random()));
        }
}
