
/*
 *	A program which calculates the average of numbers in an array. 
 */

class Average {
	public static void main (String[] args) {
		double sum = 0, average = 0;
		double[] numbers = ArrayUtils.getArray();
		for (int i = 0; i < numbers.length; i++)
			sum += numbers[i];
		average = (sum / numbers.length);
		System.out.println("Average : " + average);
	}
}


/*
 * 	Variable Description :
 *      ---------------------------------------------------------------------------------
 *	Serial no. |	Variable name	|	Data type	|	Purpose
 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	   1	   |	sum		|	double		|  Stores the sum of the 
 *	   	   |			|			|  numbers entered
 *	-----------+--------------------+-----------------------+------------------------
 *	   2	   |	average		|	double		|  Stores the average of 
 *	   	   |			|			|  the numbers entered
 *      -----------+--------------------+-----------------------+------------------------
 *	   3	   |	numbers		|	double[]	|  Store the numbers
 *	   	   |			|			|  entered
 *      -----------+--------------------+-----------------------+------------------------
 *	   4	   |	i		|	int		|  Counter variable
 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
