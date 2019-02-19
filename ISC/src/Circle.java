public class Circle implements Shape2D, Scalable<Circle> {
        protected final double radius;

        public Circle (double radius) {
                this.radius = radius;
        }

        @Override
        public double getArea () {
                return Math.PI * radius * radius;
        }

        @Override
        public double getPerimeter () {
                return 2 * Math.PI * radius;
        }

        @Override
        public Circle scale (double scaleFactor) {
                return new Circle(radius * scaleFactor);
        }

        @Override
        public String toString () {
                return String.format("Circle (radius = %f)", radius);
        }
}
