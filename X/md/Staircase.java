	
	/*
	 *	A program which displays (n) lines of the following pattern.
	 *		     
	 *		     1
	 *		    21
	 *		   321
	 *		  ....
	 *		 n...1
	 *
	 *	Example :
	 *	  (n = 3)
	 *	  	     1
	 *		    21
	 *		   321
	 */
	
	import java.util.Scanner;
	
	class Staircase {
		public static void main (String[] args) {
			System.out.print("Enter a number : ");
			int number = (new Scanner(System.in)).nextInt();
			for (int i = 1; i <= number; i++) {
				for (int j = number - i; j >= 0; j--)
					System.out.print(" ");
				for (int j = i; j > 0; j--)
					System.out.print(j);
				System.out.print("\n");
			}
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
	 *	   2	   |	i		|	int		|  Counter variable (line 
	 *	   	   |			|			|  number)
	 *	-----------+--------------------+-----------------------+------------------------
	 *	   3	   |	j		|	int		|  Counter variable
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */ 
