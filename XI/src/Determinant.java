import java.util.Scanner;

public class Determinant {
	public static void main (String[] args) {
		Scanner inp = new Scanner(System.in);
		try {
			System.out.print("Enter the size of the (size X size) square matrix : ");
			int size = inp.nextInt();
			SquareMatrix matrix = new SquareMatrix(size);
			System.out.println("Enter " + (size * size) + " integers : ");
			for (int i = 1; i <= size; i++)
				for (int j = 1; j <= size; j++)
					matrix.setElementAt(inp.nextInt(), i, j);
			System.out.println("\nThe determinant is : " + matrix.getDeterminant());
		} catch (Exception e) {
			System.out.println("Invalid Input!");
		}
	}

	public static void showMatrix (Matrix m) {
		for (int i = 1; i <= m.getRows(); i++) {
			for (int j = 1; j <= m.getColumns(); j++) {
				System.out.printf("%4d ", m.getElementAt(i, j));
			}
			System.out.println();
		}
	}
}
