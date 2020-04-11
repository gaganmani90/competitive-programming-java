package dataStructure.array.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    int[][] matrix;

    public SpiralMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public List<Integer> spiralOrder() {
        List<Integer> result = new ArrayList<>();
        double totalLayers = Math.ceil(Math.min(matrix.length, matrix[0].length) /2.0);
        int layer = 0;
        while(layer <= totalLayers) {
            result.addAll(extractSpiral(layer++));
        }

        return result;
    }

    /**
     * layer repreesents what level of spiral we are traversing.
     * Example: layer = 1 means that we are 1 level inside.
     * @param layer
     * @return
     */
    private List<Integer> extractSpiral(int layer) {
        List<Integer> spiral = new ArrayList<>();
        //read first row
        for(int col = layer; col < matrix[0].length - layer; col++) {
                spiral.add(matrix[layer][col]);
        }

        //read column downward
        for(int row = layer + 1; row < matrix.length - layer; row++) {
            spiral.add(matrix[row][matrix[0].length - layer -1]);
        }

        //read row in reverse
        for(int col = matrix.length - 2 - layer; col >= layer; col--) {
            spiral.add(matrix[matrix.length - 1 - layer][col]);
        }

        //read column upward
        for(int row = matrix.length - layer - 2; row > layer; row--) {
            spiral.add(matrix[row][layer]);
        }
        return spiral;
    }

}


