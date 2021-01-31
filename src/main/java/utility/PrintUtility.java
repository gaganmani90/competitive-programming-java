package utility;

public class PrintUtility {
    public static String print2dArray(boolean[][] arr) {
        StringBuilder out = new StringBuilder();
        for (boolean[] x : arr) {
            for (boolean y : x) {
                out.append(y + " ");
            }
            out.append("\n");
        }
        return out.toString();
    }
}
