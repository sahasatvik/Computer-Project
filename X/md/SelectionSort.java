	
	/*
	 *	A program which sorts an array. 
	 */
	
	
	class SelectionSort {
		public static void main (String[] args) {
			double[] numbers = ArrayUtils.getArray();
			selectionSort(numbers);
			for (double n : numbers)
				System.out.print(n + " ");
			System.out.print("\n");
		}
		public static void selectionSort (double[] arr) {
			for (int i = 0, left = 0; left < arr.length; left++) {
				i = indexOfLowest(arr, left, arr.length);
				ArrayUtils.swap(arr, left, i);
			}
		}
		public static int indexOfLowest (double[] arr, int left, int right) {
			int lowest = left;
			for (int i = left; i < right; i++)
				if (arr[lowest] > arr[i])
					lowest = i;
			return lowest;
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
	 *      -----------+--------------------+-----------------------+------------------------
	 *	   4	   |	lowest		|	int		|  Store index of the
	 *	   	   |			|			|  lowest number
	 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */
