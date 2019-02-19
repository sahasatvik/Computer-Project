public class ShapeDemo {
        public static void main (String[] args) {
                /* Shapes of all kinds can be stored under the same type - Shape */
                Shape[] shapes = {
                        new Circle(1.0),
                        new Cube(2.0),
                        new Triangle(3.0, 4.0, 5.0)
                };

                /* Each shape overrides the toString() method */
                System.out.println("Shapes :");
                for (Shape s : shapes)
                        System.out.println(s);
                System.out.println();

                /* 2D shapes can be stored under the same type - Shape2D */
                Shape2D[] flatShapes = {
                        new Circle(1.0),
                        new Triangle(1.0, 1.0, 1.0),
                        new Square(1.0)
                };

                /* Each shape overrides the getArea() and getPerimeter() methods */
                System.out.println("2D Shapes :");
                for (Shape2D s2D : flatShapes)
                        System.out.printf("%-66s area = %4f perimeter = %8f\n",
                                        s2D,
                                        s2D.getArea(),
                                        s2D.getPerimeter());
                System.out.println();

                /* Scalable shapes can be stored under the same type - Scalable */
                Scalable[] scalable = {
                        new LineSegment(1.0),
                        new Sphere(1.0),
                        new Cuboid(1.0, 2.0, 3.0)
                };

                /* Each scalable shape overrides the scale() method */
                System.out.println("Scalable :");
                for (Scalable sc : scalable)
                        System.out.printf("%-66s scaled by 3 is %-66s\n", sc, sc.scale(3));
                System.out.println();
        }
}
