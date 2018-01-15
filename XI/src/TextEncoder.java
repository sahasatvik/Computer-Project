import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TextEncoder {
	public static void main (String[] args) throws Exception {
		try {
			CodeSubstituter cs = new CodeSubstituter(args[0]);
			
			System.out.print("Enter a sentence to encode : ");
			String sentence = (new Scanner(System.in)).nextLine();
			String[] words = sentence.split("\\s+");
			
			System.out.print("Encoded sentence           : ");
			for (int i = 0; i < words.length; i++) {
				String encodedText = cs.getEncodedText(words[i].toLowerCase().replaceAll("[^a-z]", ""));
				System.out.print(encodedText + " ");
			}	
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Enter 1 argument ([codebook_filename])");
		} catch (FileNotFoundException e) {
			System.out.println("Codebook not found! Enter a valid filename.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
