public class Launcher {
    public static void main(String args[]) {
        System.out.println("\n\nTest for compare methods. \n");

        System.out.print("Compare 10 and 20 : ");
        Compare.compare(10, 20);

        System.out.print("Compare 'a' and 'z' : ");
        Compare.compare('a', 'z');

        System.out.print("Compare \"12345\" and \"123\" : ");
        Compare.compare("12345", "123");

        System.out.print("\n\n");

    }
}
