package problemSolving;

import java.util.Arrays;
import java.util.stream.Collectors;


public class MatrixUtility {

    public static String getString(int[][] array) {
        String result = "\n"+Arrays
                .stream(array)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        return result;
    }

    public static void print2dArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void print2dArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static boolean equals(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}