package programs.array;

/**
 * @author gagamani
 * @date 9/20/18
 */
public class KthLargest {

    static int kthLargest(int k, int[] arr){
        int large = -1;

        for(int i = 1; i <= arr.length-1; i++){
            int key = arr[i];
            int j = i-1;

            if(j>=0 && arr[j] < key){

            }
        }

        return large;

    }
}
