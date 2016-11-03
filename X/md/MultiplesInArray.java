	
	/*
	 *	A program which displays all the multiples of a number in an array. 
	 */
	
	import java.util.Scanner;
	
	class MultiplesInArray {
		public static void main (String[] args) {
			double[] numbers = ArrayUtils.getArray();
			System.out.print("Enter the number whose multiples are to be shown : ");
			double n = (new Scanner(System.in)).nextDouble();
			for (int i = 0; i < numbers.length; i++)
				if (isMultipleOf(numbers[i], n))
					System.out.print(numbers[i] + " ");
			System.out.print("\n");
		}
		public static boolean isMultipleOf (double number, double factor) {
			return (number % factor) == 0;
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
	 *	   2	   |	n		|	double		|  Stores the number 
	 *	   	   |			|			|  whose multiples are 
	 *	   	   |			|			|  to be displayed
	 *      -----------+--------------------+-----------------------+------------------------
	 *	   3	   |	i		|	int		|  Counter variable
	 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */
