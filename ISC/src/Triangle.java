public class Triangle implements Shape2D, Scalable<Triangle> {
        protected final double a;
        protected final double b;
        protected final double c;

        public Triangle (double a, double b, double c) {
                this.a = a;
                this.b = b;
                this.c = c;
        }

        @Override
                public double getArea () {
                        double s = (a + b + c) / 2.0;
                        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
                }

        @Override
                public double getPerimeter () {
                        return a + b + c;
                }

        @Override
                public Triangle scale (double scaleFactor) {
                        return new Triangle(a * scaleFactor, b * scaleFactor, c * scaleFactor);
                }

        @Override
                public String toString () {
                        return String.format("Triangle (sides = {%f, %f, %f})", a, b, c);
                }
}
