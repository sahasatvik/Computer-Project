
/*
 *	A program which checks whether the number entered is a perfect number.
 *
 *	A number is perfect if it is equal to the sum of all of its factors 
 * 	(excluding itself).
 *
 *	Example :
 *		6 = 1 * 2 * 3
 *		   ^---------^ 1 + 2 + 3 = 6	--->	Perfect!
 *		
 *		28 = 1 * 2 * 4 * 7 * 14
 *		    ^------------------^ 1 + 2 + 4 + 7 + 14 = 28    --->    Perfect!
 */


import java.util.Scanner;

class Perfect {
	public static void main (String[] args) {
		System.out.print("Enter a number : ");
		int number = (new Scanner(System.in)).nextInt();
		int sumOfFactors = 0;
		for (int factor = 1; factor < number; factor++)
			sumOfFactors += ((number % factor) == 0)? factor : 0;
		System.out.println((number == sumOfFactors)
					? "Perfect number!" : "Not a Perfect number!");
	}
}


/*
 * 	Variable Description :
 *      ---------------------------------------------------------------------------------
 *	Serial no. |	Variable name	|	Data type	|	Purpose
 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	   1	   |	number		|	int		|  Stores the number 
 *	   	   |			|			|  entered
 *	-----------+--------------------+-----------------------+------------------------
 *	   2	   |	sumOfFactors	|	int		|  Stores the sum of 
 *	   	   |			|			|  the factors of (number)
 *      -----------+--------------------+-----------------------+------------------------
 *	   3	   |	factor		|	int		|  Stores each possible
 *	   	   |			|			|  factor of (number)
 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
