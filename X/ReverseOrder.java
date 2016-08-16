
/*
 *	A program which prints the words of a sentence in reverse order.
 *
 *	Example :
 *	  (sentence = "to be or not to be, that is the question")
 *	  	question the is that be, to not or be to
 */


import java.util.Scanner;

class ReverseOrder {
	public static void main (String[] args) {
		System.out.print("Enter a sentence : ");
		String sentence = (new Scanner(System.in)).nextLine();
		while (sentence.lastIndexOf(' ') > 0) {
			System.out.print(sentence.substring(sentence.lastIndexOf(' ') + 1) + " ");
			sentence = sentence.substring(0, sentence.lastIndexOf(' '));
		}
		System.out.print(sentence + "\n");
	}
}


/*
 * 	Variable Description :
 *      ---------------------------------------------------------------------------------
 *	Serial no. |	Variable name	|	Data type	|	Purpose
 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	   1	   |	sentence	|	String		|  Stores the sentence
 *	   	   |			|			|  entered
 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
