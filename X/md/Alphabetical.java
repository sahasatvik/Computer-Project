	
	/*
	 *	A program which prints the letters of a word (entered in the command line) 
	 *	in alphabetical order.
	 */
	
	
	class Alphabetical {
		public static void main (String[] args) {
			String word = (args.length == 0)? "DEFAULT" : args[0].toUpperCase();
			int[] count = new int[256];
			for (int i = 0; i < word.length(); i++)
				count[word.charAt(i)]++;
			for (int i = 0, j = 0; i < 255; j = count[++i])
				while (j --> 0)
					System.out.print((char)(i));
			System.out.print("\n");
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
	 *	   2	   |	count		|	int[]		|  Stores the number
	 *	   	   |			|			|  of occurrences of
	 *	   	   |			|			|  the character, whose
	 *	   	   |			|			|  ASCII value is the
	 *	   	   |			|			|  index of the count
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   3	   |	i		|	int		|  Counter variable
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */
