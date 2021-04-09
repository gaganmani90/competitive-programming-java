package problemSolving.ctci;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import problemSolving.MatrixUtility;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
@Slf4j
public class MatrixAllZero {

    public int[][] zeroMatrix(int[][] matrix) {
        log.info("zeroMatrix");
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        //mark rows and columns which should be zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int i = 0; i < col.length; i++) {
            if (col[i]) {
                nullifyColumn(matrix, i);
            }
        }
        log.info(MatrixUtility.getString(matrix));
        return matrix;
    }

    public int[][] zeroMatrixOptimized(int[][] matrix) {
        log.info("zeroMatrixOptimized input");
        log.info(MatrixUtility.getString(matrix));
        boolean rowHasZero = false;
        boolean colHasZero = false;

        //STEP-1: check first row and column
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        //STEP-2: mark first row and column as 0 if necessary
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0; //first row
                    matrix[i][0] = 0; //first column
                }
            }
        }

        //STEP-3a: mark the column as 0 based on first row entries
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }
        //STEP-3b: mark the row as 0 based on first column entries
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        //STEP-4: mark first row and first column as 0 if necessary
        if(rowHasZero) {
            nullifyRow(matrix, 0);
        }
        if(colHasZero) {
            nullifyColumn(matrix, 0);
        }

        log.info(MatrixUtility.getString(matrix));
        return matrix;
    }

    private void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        MatrixAllZero matrixAllZero = new MatrixAllZero();
        int[][] expectedMatrix = {
                {0, 0, 0, 0},
                {5, 7, 7, 0},
                {9, 10, 11, 0},
                {13, 14, 15, 0},
        };
        Assert.assertTrue(MatrixUtility.equals(matrixAllZero.zeroMatrix(mock()), expectedMatrix));

        Assert.assertTrue(MatrixUtility.equals(matrixAllZero.zeroMatrixOptimized(mock()), expectedMatrix));
    }

    private static int[][] mock() {
        int[][] matrix = {
                {1, 2, 3, 0},
                {5, 7, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        return matrix;
    }
}
