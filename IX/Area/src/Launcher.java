public class Launcher {
    public static void main(String args[]) {
        System.out.println("\n\nTest for area methods. \n");

        System.out.print("Area of equilateral triangle (side = 10) = ");
        Area.area(10);

        System.out.print("Area of right-angled triangle (base = 10, height = 20) = ");
        Area.area(10, 20);

        System.out.print("Area of scalene triangle (sides = {2, 3, 4}) = ");
        Area.area(2, 3, 4);

        System.out.print("\n\n");

    }
}
