public class Compare {
    public static void compare(int a, int b) {
        System.out.println((a > b) ? a : b);
    }

    public static void compare(char a, char b) {
        System.out.println((a > b) ? a : b);
    }

    public static void compare(String a, String b) {
        System.out.println((a.length() > b.length()) ? a : b);
    }
}
