import java.util.Scanner;

public class Palindrome {
        public static void main (String[] args) {
                System.out.print("Enter your sentence : ");
                String sentence = (new Scanner(System.in)).nextLine().trim();
                /* Keep track of whether palindromes have been found */
                boolean foundPalindrome = false;
                System.out.println("Palindromes : ");
                foundPalindrome |= checkWords(sentence);
                foundPalindrome |= checkSentence(sentence);
                if (!foundPalindrome) {
                        System.out.println("(No palindromes found!)");
                }
        }

        /* Slice a sentence into words and check each individually */
        public static boolean checkWords (String sentence) {
                boolean foundPalindrome = false;
                int start = -1;
                int end = 0;
                while (end < sentence.length()) {
                        while (Character.isWhitespace(sentence.charAt(++start)));
                        end = start;
                        while (end < sentence.length() && !Character.isWhitespace(sentence.charAt(end++)));
                        String word = sentence.substring(start, end).trim();
                        if (isPalindrome(word)) {
                                foundPalindrome = true;
                                System.out.println(getAlphabets(word));
                        }
                        start = end - 1;
                }
                return foundPalindrome;
        }

        /* Check the sentence as a whole */
        public static boolean checkSentence (String sentence) {
                if (isPalindrome(sentence)) {
                        System.out.println("The sentence '" + sentence + "' is a palindrome.");
                        return true;
                }
                return false;
        }

        /* Check whether a piece of text is identical forward as well as backwards */
        public static boolean isPalindrome (String text) {
                String rawText = getAlphabets(text).toUpperCase();
                for (int i = 0, j = rawText.length() - 1; i < j; i++, j--) {
                        if (rawText.charAt(i) != rawText.charAt(j)) {
                                return false;
                        }
                }
                /* Make sure that the text is not just one letter */
                return (rawText.length() > 1);
        }

        /* Strip a piece of text of all characters except alphabetic ones */
        public static String getAlphabets (String text) {
                String rawText = "";
                for (int i = 0; i < text.length(); i++) {
                        if (Character.isAlphabetic(text.charAt(i))) {
                                rawText += text.charAt(i);
                        }
                }
                return rawText;
        }
}
