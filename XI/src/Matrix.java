public class Matrix {
	protected final int rows;
	protected final int columns;
	protected int[][] elements;

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

	public void setElementAt (int element, int row, int column) {
		if (row < 1 || row > rows || column < 1 || column > columns)
			return;
		elements[row-1][column-1] = element;
	}

	public int getElementAt (int row, int column) {
		if (row < 1 || row > rows || column < 1 || column > columns)
			return Integer.MIN_VALUE;
		return elements[row-1][column-1];
	}
} 
