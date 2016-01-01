public class Area {
    public static void area(int a) {
        System.out.println((Math.sqrt(3.0) / 4.0) * a * a);
    }

    public static void area(int a, int b) {
        System.out.println((1.0 / 2.0) * a * b);
    }

    public static void area(int a, int b, int c) {
        double s = (a + b + c) / 2.0;
        System.out.println(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
    }
}