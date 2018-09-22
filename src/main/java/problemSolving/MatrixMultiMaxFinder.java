package problemSolving;


public class MatrixMultiMaxFinder {
    
    private int find(int[][] array,  int x, int y) {
        int max = Integer.MIN_VALUE;
    
        if (y >= array.length || x >= array[y].length) {
            return max;
        }
    
        boolean checkDiagonal = true;
        if (array.length - y >= 4) {
            max = array[y][x] * array[y+1][x] * array[y+2][x] * array[y+3][x];  
        } else {
            checkDiagonal = false;
        }

        if (array[y].length - x >= 4) {
            int val = array[y][x] * array[y][x+1] * array[y][x+2] * array[y][x+3];  
            max = Math.max(max, val);
        } else {
            checkDiagonal = false;
        }
        
        if (checkDiagonal) {
            int val = array[y][x] * array[y+1][x+1] * array[y+2][x+2] * array[y+3][x+3];  
            if (val > max) {
                max = val;
            }
        }
        
// move the x position
        max = Math.max(max, find(array, x+1, y));

        return max;
    }
    
    public void doit(int[][] array) {
        int max = Integer.MIN_VALUE;

// move the y position
        for (int y = 0; y < array.length; y++) {
            max = Math.max(max, find(array, 0, y));
        }
        
        System.out.println(max);
   }

    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 0, -1 ,4},
            {3, 1, 2, 4, 6},
            {0, 6, 3, 1, 4},
            {1, 3, 2, 0, 7},
            {2, 0, 3, 2, 9}};
            
        MatrixMultiMaxFinder cl = new MatrixMultiMaxFinder();
        cl.doit(array);
    }
    
}
