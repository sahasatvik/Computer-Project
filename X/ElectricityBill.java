
/*
 *	A program which calculates and displays the electricity bill, based upon the
 *	following table :
 *		
 *		--------------------------------------------------------------------
 *		Units consumed (kWh)	|	Price per unit in the slab (Rs)
 *		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *		  < 100			|	   	5
 *		    100  -  150		|	   	6
 *		    150  -  200		|	   	7
 *		  > 	    200		|	   	8
 *		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */


import java.util.Scanner;

class ElectricityBill {
	public static void main (String[] args) {
		System.out.print("Enter the number of units consumed : ");
		double units = (new Scanner(System.in)).nextDouble();
		double bill = 0;
		if (units < 100)
			bill += (5.00 * units);
		else if (units < 150)
			bill += (5.00 * 100) + (6.00 * (units - 100));
		else if (units < 200)
			bill += (5.00 * 100) + (6.00 * 50) + (7.00 * (units - 150));
		else
			bill += (5.00 * 100) + (6.00 * 50) + (7.00 * 50) + (8.00 * (units - 200));
		System.out.printf("Your bill amount is : Rs. %9.2f%n", bill);
	}
}


/*
 * 	Variable Description :
 *      ---------------------------------------------------------------------------------
 *	Serial no. |	Variable name	|	Data type	|	Purpose
 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	   1	   |	units		|	double		|  Stores the number 
 *	   	   |			|			|  of units
 *	-----------+--------------------+-----------------------+------------------------
 *	   2	   |	bill		|	double		|  Stores the bill
 *	   	   |			|			|  amount
 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
