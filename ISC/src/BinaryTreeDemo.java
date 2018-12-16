import java.util.Scanner;

public class BinaryTreeDemo {
	public static void main (String[] args) {
		/* Create a binary tree which holds strings */
		BinaryTree<String> bTree = new BinaryTree<String>();

		/* Get a line of input */
		System.out.print("Enter a sentence : ");
		String sentence = (new Scanner(System.in)).nextLine();

		/* Only retain letters */
		sentence = sentence.toUpperCase().replaceAll("[^A-Z]", " ");
		
		/* Insert each word into the tree. This implicitly sorts them. */
		for (String word : sentence.split("\\s+"))
			bTree.add(word);

		/* In order traversal of the tree */
		System.out.print("Sorted words : ");
		System.out.println(bTree);
	}
}
