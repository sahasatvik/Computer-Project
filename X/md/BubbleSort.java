	
	/*
	 *	A program which sorts an array. 
	 */
	
	
	class BubbleSort {
		public static void main (String[] args) {
			double[] numbers = ArrayUtils.getArray();
			bubbleSort(numbers);
			for (double n : numbers)
				System.out.print(n + " ");
			System.out.print("\n");
		}
		public static void bubbleSort (double[] arr) {
			for (int left = 0; left < arr.length; left++) 
				for (int i = 1; i < arr.length - left; i++)
					if (arr[i] < arr[i - 1])
						ArrayUtils.swap(arr, i, i - 1);
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
	 *	   2	   |	left		|	int		|  Counter variable
	 *      -----------+--------------------+-----------------------+------------------------
	 *	   3	   |	i		|	int		|  Counter variable
	 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */
