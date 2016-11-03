	
	/*
	 *	A program which searches for a number in an array. 
	 */
	
	
	import java.util.Scanner;
	
	class BinarySearch {
		public static void main (String[] args) {
			double[] numbers = ArrayUtils.getArray();
			BubbleSort.bubbleSort(numbers);
			System.out.print("Enter the number to search : ");
			double n = (new Scanner(System.in)).nextDouble();
			int index = binarySearch(n, numbers);
			System.out.println((index == -1)? "Number not found" : 
							 "Number found at " + index);
		}
		public static int binarySearch (double n, double[] arr) {
			int mid, left = 0, right = arr.length - 1;
			while (left <= right) {
				mid = (left + right) / 2;
				if (n < arr[mid])	right = mid - 1;
				else if (n > arr[mid])	left = mid + 1;
				else			return mid;
			}
			return -1;
		}
	}
	
	/*
	 * 	Variable Description :
	 *      ---------------------------------------------------------------------------------
	 *	Serial no. |	Variable name	|	Data type	|	Purpose
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	   1	   |	n		|	int		|  Stores the number to
	 *	   	   |			|			|  be searched for
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   2	   |	mid		|	int		|  Stores the index of
	 *	   	   |			|			|  the midpoint of 'arr'
	 *      -----------+--------------------+-----------------------+------------------------
	 *	   3	   |	numbers		|	double[]	|  Store the numbers
	 *	   	   |			|			|  entered
	 *      -----------+--------------------+-----------------------+------------------------
	 *	   4	   |	index		|	int		|  Store the index of 'n'
	 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */
