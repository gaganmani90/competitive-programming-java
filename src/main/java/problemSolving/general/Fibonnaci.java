package problemSolving.general;

/**
 *
 * 0, 1, 1, 2 , 3, 5, 8, 13, 21, 34
 * @author gagamani
 * @date 9/17/18
 */
public class Fibonnaci {

    /**
     * Method-1 iterative approach
     * @param n
     * @return
     */
    static int get(int n){
        int nthNumber = -1;
        int a = 0;
        int b = 1;

        if(n == 1){
            return a;
        }
        else if(n == 2){
            return b;
        }
        else{
            for(int i = 3; i <= n; i++){
                nthNumber = a+b;
                int temp = b;
                b = nthNumber;
                a = temp;

            }
        }


        return nthNumber;
    }

    /**
     * Method-2 Recursive approach
     * @param n
     * @return
     */
    static int get_recursive(int n){
        if(n <=0 ){
            return -1;
        }
        if(n == 1){
            return 0;
        }
        else if(n == 2){
            return 1;
        }
        else{
            return get_recursive(n-1)+get_recursive(n-2);
        }

    }
}
