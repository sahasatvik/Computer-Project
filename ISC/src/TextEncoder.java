import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TextEncoder {
        public static void main (String[] args) throws Exception {
                try {
                        /* Parse the first command line argument as the path to the codebook */
                        CodeSubstituter cs = new CodeSubstituter(args[0]);

                        /* Get a sentence to encode, and extract the individual words */
                        System.out.print("Enter a sentence to encode : ");
                        String sentence = (new Scanner(System.in)).nextLine();
                        String[] words = sentence.split("\\s+");

                        System.out.print("Encoded sentence           : ");
                        /* Iterate through each word, replacing it with the codeword in the codebook */
                        for (int i = 0; i < words.length; i++) {
                                String encodedText = cs.getEncodedText(words[i].toLowerCase().replaceAll("[^a-z]", ""));
                                System.out.print(encodedText + " ");
                        }
                        System.out.println();
                } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Enter 1 argument ([codebook_filename])");
                } catch (FileNotFoundException e) {
                        System.out.println("Codebook not found! Enter a valid filename.");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}
