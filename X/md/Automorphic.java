	
	/*
	 *	A program which checks whether the number entered is automorphic.
	 *
	 *	A number is automorphic if it is contained in the last digits of its square.
	 *	
	 *	Example :
	 *		25 * 25 = 625	--->	6 2 5
	 *			 		 ^---^ = 25	--->	Automorphic!
	 */
	
	
	import java.util.Scanner;
	
	class Automorphic {
		public static void main (String[] args) {
			System.out.print("Enter a number : ");
			int number = (new Scanner(System.in)).nextInt();
			int square = number * number;
			int mask = (int) Math.pow(10, numberOfDigits(number));
			System.out.println((number == (square % mask))
					? "Automorphic number!" : "Not an Automorphic number!");
		}
		public static int numberOfDigits (int n) {
			return (n < 10) ? 1 : numberOfDigits(n / 10) + 1;
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
	 *	   2	   |	square		|	int		|  Stores the square of 
	 *	   	   |			|			|  the number entered
	 *      -----------+--------------------+-----------------------+------------------------
	 *	   3	   |	mask		|	int		|  Stores the mask ; 
	 *	   	   |			|			|  divding a number by
	 *	   	   |			|			|  this gives its last
	 *	   	   |			|			|  few digits
	 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */
