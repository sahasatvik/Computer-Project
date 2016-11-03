	
	/*
	 *	A program which displays a diamond pattern, whose breadth is (2n -1),
	 *	where (n) is chosen by the user.
	 *
	 *	Example :
	 *	  (n = 3)
	 *	
	 *		   *
	 *		  ***
	 *		 *****
	 *		  ***
	 *		   *
	 */
	
	
	import java.util.Scanner;
	
	class Diamond {
		public static void main (String[] args) {
			System.out.print("Enter a number : ");
			int number = (new Scanner(System.in)).nextInt();
			for (int i = 1 - number; i < number; i++) {
				for (int j = Math.abs(i); j >= 0; j--)
					System.out.print(" ");
				for (int j = (2 * (number - Math.abs(i))) - 1; j > 0; j--)
					System.out.print("*");
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
