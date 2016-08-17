
/*
 *	A set of functions which prints the greater of two :
 *		
 *		-> Integers
 *		-> Characters
 *		-> Strings	(greater means longer)
 */


class Compare {
    public static void greater (int a, int b) {			// Integers
        System.out.println((a > b) ? a : b);
    }
    public static void greater (char a, char b) {		// Characters
        System.out.println((a > b) ? a : b);
    }
    public static void greater (String a, String b) {		// Strings
        System.out.println((a.length() > b.length()) ? a : b);
    }
}
