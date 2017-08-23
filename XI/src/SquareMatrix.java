public class SquareMatrix extends Matrix {
	protected int size;
	public SquareMatrix (int size) {
		super(size, size);
		this.size = size;
	}

	public int getSize () {
		return this.size;
	}

	public int getDeterminant () {
		if (this.size == 1)
			return getElementAt(1, 1);
		if (this.size == 2)
			return (getElementAt(1, 1) * getElementAt(2, 2))
				- (getElementAt(1, 2) * getElementAt(2, 1));
		int determinant = 0;
		for (int i = 1; i <= size; i++)
			determinant += ((int) Math.pow(-1, 1+i)) * getElementAt(1, i) 
								 * getMinorMatrix(1, i).getDeterminant();
		return determinant;
	}

	public SquareMatrix getMinorMatrix (int row, int column) {
		if (row < 1 || row > size || column < 1 || column > size)
			return null;
		if (this.size <= 1)
			return new SquareMatrix(0);
		SquareMatrix minor = new SquareMatrix(this.size - 1);
		for (int i = 1, p = 1; p < size; i++, p++) {
			if (i == row)
				i++;
			for (int j = 1, q = 1; q < size; j++, q++) {
				if (j == column)
					j++;
				minor.setElementAt(this.getElementAt(i, j), p, q);
			}
		}
		return minor;
	}
}
