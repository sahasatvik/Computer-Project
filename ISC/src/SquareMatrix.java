public class SquareMatrix extends Matrix {
        protected int size;

        /* Initialize the matrix with the same number of rows and columns */
        public SquareMatrix (int size) {
                super(size, size);
                this.size = size;
        }

        public int getSize () {
                return this.size;
        }

        /* Recursively calculate the determinant of the matrix */
        public int getDeterminant () {
                /* Base cases */
                if (this.size == 1)
                        return getElementAt(1, 1);
                if (this.size == 2)
                        return (getElementAt(1, 1) * getElementAt(2, 2))
                                - (getElementAt(1, 2) * getElementAt(2, 1));
                int determinant = 0;
                /* Accumulate the determinants of minors with alternating signs */
                for (int i = 1; i <= size; i++)
                        determinant += ((int) Math.pow(-1, 1+i)) 
                                * getElementAt(1, i)
                                * getMinorMatrix(1, i).getDeterminant();
                return determinant;
        }

        /* Get the minor matrix by removing a row and a column */
        public SquareMatrix getMinorMatrix (int row, int column) {
                /* Check bounds */
                if (row < 1 || row > size || column < 1 || column > size)
                        return null;
                if (this.size <= 1)
                        return new SquareMatrix(0);
                SquareMatrix minor = new SquareMatrix(this.size - 1);
                for (int i = 1, p = 1; p < size; i++, p++) {
                        /* Skip 'row' */
                        if (i == row)
                                i++;
                        for (int j = 1, q = 1; q < size; j++, q++) {
                                /* Skip 'column' */
                                if (j == column)
                                        j++;
                                /* Copy values into the new matrix */
                                minor.setElementAt(this.getElementAt(i, j), p, q);
                        }
                }
                return minor;
        }
}
