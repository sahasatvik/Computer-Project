import java.util.Scanner;

class Palindrome {
	public static void main (String[] args) {
		System.out.print("Enter your sentence : ");
		String sentence = (new Scanner(System.in)).nextLine().trim();
		boolean noMatch = true;
		System.out.println("Palindromes : ");
		noMatch &= checkWords(sentence);
		noMatch &= checkSentence(sentence);
		if (noMatch) {
			System.out.println("(None found!)");
		}
	}

	public static boolean checkWords (String sentence) {
		boolean noMatch = true;
		int start = -1;
		int end = 0;
		while (end < sentence.length()) {
			while (Character.isWhitespace(sentence.charAt(++start)));
			end = start;
			while (end < sentence.length() 
				&& !Character.isWhitespace(sentence.charAt(end++)));
			
			String word = sentence.substring(start, end).trim();
			if (isPalindrome(word)) {
				noMatch = false;
				System.out.println(getAlphabets(word));
			}
			start = end - 1;
		}
		return noMatch;
	}

	public static boolean checkSentence (String sentence) {
		if (isPalindrome(sentence)) {
			System.out.println(sentence);
			return false;
		}
		return true;
	}

	public static boolean isPalindrome (String text) {
		String rawText = getAlphabets(text).toUpperCase();
		for (int i = 0, j = rawText.length() - 1; i < j; i++, j--) {
			if (rawText.charAt(i) != rawText.charAt(j)) {
				return false;
			}
		}
		return (rawText.length() > 1);
	}

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
