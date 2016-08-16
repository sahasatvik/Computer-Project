
/*
 *	A set of functions which calculate the areas of the following
 *	geometrical figures :
 *		
 *		-> Square		(side * side)
 *		-> Rectangle		(length * breadth)
 *		-> Trapezium		((1/2) * (sum of parallel sides) * height)
 */


class Area {
	public static double area (double side) {				// Square
		return area(side, side);
	}
	public static double area (double length, double breadth) {		// Rectangle
		return area(length, length, breadth);
	}
	public static double area (double a, double b, double height) {	// Trapezium
		return 0.5 * (a + b) * height;
	}
}
