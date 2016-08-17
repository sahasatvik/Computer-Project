
/*
 *	A program which displays all permutations of a word 
 *	(entered in the command line).
 *
 *	Example :
 *	  (word = "ABC")
 *	  	ABC
 *	  	ACB
 *	  	BAC
 *	  	BCA
 *	  	CAB
 *	  	CBA
 */

class Permutations {
	public static void main (String[] args) {
		String word = (args.length == 0)? "DEFAULT" : args[0].toUpperCase();
		permute("", word);
	}
	public static void permute (String prefix, String str) {
		if (str.length() == 0)
			System.out.println(prefix);
		for (int i = 0; i < str.length(); i++)
			permute(prefix + str.charAt(i), 
				str.substring(0, i) + str.substring(i + 1));
	}
}

/*
 * 	Variable Description :
 *      ---------------------------------------------------------------------------------
 *	Serial no. |	Variable name	|	Data type	|	Purpose
 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	   1	   |	word		|	String		|  Stores the word
 *	   	   |			|			|  entered
 *	-----------+--------------------+-----------------------+------------------------
 *	   2	   |	prefix		|	String		|  Stores the partially
 *	   	   |			|			|  created permutation
 *      -----------+--------------------+-----------------------+------------------------
 *	   3	   |	str		|	String		|  Stores the remaining 
 *	   	   |			|			|  word, after letters
 *	   	   |			|			|  are pulled into the
 *	   	   |			|			|  (prefix)
 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
