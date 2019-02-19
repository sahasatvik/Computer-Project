public class CaesarShift {
        public static void main (String[] args) {
                try {
                        /* Parse the first command line argument as the shift */
                        int shift = Integer.parseInt(args[0]) % 26;
                        /* Parse the second command line argument as the text to encrypt */
                        String plaintext = args[1].toUpperCase();
                        String ciphertext = "";
                        for (int i = 0; i < plaintext.length(); i++) {
                                char plain = plaintext.charAt(i);
                                char crypt = ' ';
                                if ('A' <= plain && plain <= 'Z') {
                                        /* Only shift letters of the alphabet */
                                        crypt = numToChar(charToNum(plain) + shift);
                                } else {
                                        /* Keep special characters intact */
                                        crypt = plain;
                                }
                                /* Append the encrypted character to the cipherText */
                                ciphertext += crypt;
                        }
                        System.out.println(ciphertext);
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        /* Handle missing or incorrectly formatted arguments */
                        System.out.println("Enter 2 arguments (shift[integer], plaintext[text])!");
                }
        }

        /* Map letters to numbers */
        public static int charToNum (char letter) {
                return Character.toUpperCase(letter) - 'A';
        }

        /* Map numbers to letters */
        public static char numToChar (int number) {
                return (char) ('A' + Math.floorMod(number, 26));
        }
} 
