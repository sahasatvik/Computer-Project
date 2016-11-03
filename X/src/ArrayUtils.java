
/*
 *	A utility class of common methods for array handling.
 */


import java.util.Scanner;

class ArrayUtils {
	public static double[] getArray () {
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter the size of the array : ");
		int size = inp.nextInt();
		double[] numbers = new double[size];
		System.out.print("Enter the numbers : ");
		for (int i = 0; i < size; i++)
			numbers[i] = inp.nextDouble();
		return numbers;
	}
	public static void swap (double[] arr, int x, int y) {
		double t = arr[x];
		arr[x] = arr[y];
		arr[y] = t;
	}
}


/*
 * 	Variable Description :
 *      ---------------------------------------------------------------------------------
 *	Serial no. |	Variable name	|	Data type	|	Purpose
 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	   1	   |	inp		|	Scanner		|  Object for input
 *      -----------+--------------------+-----------------------+------------------------
 *	   2	   |	size		|	int		|  Store the size of the 
 *	   	   |			|			|  array 'numbers[]'
 *      -----------+--------------------+-----------------------+------------------------
 *	   3	   |	numbers		|	double[]	|  Store the numbers
 *	   	   |			|			|  entered
 *      -----------+--------------------+-----------------------+------------------------
 *	   4	   |	i		|	int		|  Counter variable
 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
