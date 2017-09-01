public class Matrix {
	protected final int rows;
	protected final int columns;
	protected int[][] elements;

	/* Initialize a matrix of a given order */
	public Matrix (int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.elements = new int[rows][columns];
	}

	public int getRows () {
		return this.rows;
	}

	public int getColumns () {
		return this.columns;
	}
	
	/* Set elements in the matrix using natural indices */
	public void setElementAt (int element, int row, int column) {
		if (row < 1 || row > rows || column < 1 || column > columns)
			return;
		elements[row-1][column-1] = element;
	}

	/* Get elements from the matrix using natural indices */
	public int getElementAt (int row, int column) {
		if (row < 1 || row > rows || column < 1 || column > columns)
			return Integer.MIN_VALUE;
		return elements[row-1][column-1];
	}
} 
