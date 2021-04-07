package problemSolving.ctci;

import problemSolving.MatrixUtility;

/**
 * Given an image represented by an NxN matrix,
 * where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 */
public class RotateMatrix {

    public static int[][] rotate(int[][] matrix) {
        //if matrix is not NxN
        if (matrix.length == 0 || matrix[0].length != matrix.length) {
            return null;
        } else {
            int n = matrix.length;
            //4x4 or 5x5 matrix will have 2 layers
            for (int layer = 0; layer < n / 2; layer++) {
                //rows for given layer
                int first = layer;
                int last = n - 1 - layer;
                for (int i = first; i < last; i++) {
                    int offset = i - first;
                    //save the top
                    int top = matrix[first][i];

                    //left -> top
                    matrix[first][i] = matrix[last - offset][first];

                    //bottom -> left
                    matrix[last-offset][first] = matrix[last][last-offset];

                    //right -> bottom
                    matrix[last][last-offset] = matrix[i][last];

                    //top -> right
                    matrix[i][last] = top;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };
        MatrixUtility.print2dArray(matrix);
        System.out.println("Rotated by 90 degree");
        MatrixUtility.print2dArray(rotate(matrix));


    }
}
