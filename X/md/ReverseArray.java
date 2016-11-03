	
	/*
	 *	A program which reverses the numbers as well as their order in an array. 
	 */
	
	class ReverseArray {
		public static void main (String[] args) {
			double[] numbers = ArrayUtils.getArray();
			for (int i = numbers.length - 1; i >= 0; i--)
				System.out.print(reverse(numbers[i]) + " ");
			System.out.print("\n");
		}
		public static String reverse (double number) {
			String numStr = Double.toString(number);
			String reversed = "";
			for (int i = numStr.length() - 1; i >= 0; i--)
				reversed += numStr.charAt(i);
			return reversed;
		}
	}
	
	
	/*
	 * 	Variable Description :
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	numbers		|	double[]	|  Store the numbers
	 *	   	   |			|			|  entered
	 *      -----------+--------------------+-----------------------+------------------------
	 *	   2	   |	numStr		|	String		|  Stores the number as 
	 *	   	   |			|			|  a String
	 *      -----------+--------------------+-----------------------+------------------------
	 *	   3	   |	reversed	|	String		|  Stores the reversed 
	 *	   	   |			|			|  number
	 *      -----------+--------------------+-----------------------+------------------------
	 *	   4	   |	i		|	int		|  Counter variable
	 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */
