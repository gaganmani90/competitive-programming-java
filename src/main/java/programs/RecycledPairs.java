package programs;

import java.util.Arrays;
import java.util.Collections;

/**
 * Number of recycled pairs in an array
 Given an array of integers arr[], find the number of recycled pairs in the array.
 A recycled pair of two numbers {a, b} has the following properties :

 A should be smaller than B.
 Number of digits should be same.
 By rotating A any number of times in one direction, we should get B.


 =======Examples=========
 Input : arr[] = {32, 42, 13, 23, 9, 5, 31}
 Output : 2
 Explanation : Since there are two pairs {13, 31} and {23, 32}.
 By rotating 13 for first time, output is 31 and by rotating 23 once output is 32.
 Both of these pairs satisfy our criteria.

 Input : arr[] = {1212, 2121}
 Output : 1
 Explanation : Since there are two pairs {1212, 2121}. By rotating 1212
 for first time, output is 2121. This pair satisfies our criteria.
 Note that if rotation id done further, rotating 1212 again output is 1212
 which is given number and 2121 which has been already counted.
 So discard both of these results.
 */
public class RecycledPairs {

    public static boolean isRecycledPairs(int a, int b){
        if(a < b){
            int aDigits = (int)Math.log10(a) + 1;
            int bDigits = (int)Math.log10(b) + 1;
            int rotatedNumber = b;
            if(aDigits == bDigits){
                for(int i = 0; i<bDigits; i++){
                    int r = rotatedNumber % 10; //i.e.b = 1234 then r = 4
                    int d = rotatedNumber / 10; //i.e. b = 1234 then r = 123
                    rotatedNumber = r * (int)Math.pow(10, (bDigits - 1)) + d; //i.e b = 4, bDigits = 4, d = 123 then rotation = 4123

                    if(rotatedNumber == a){
                        return true;
                    }
                }
                return false;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public static int numberOfRecycledPairs(int[] arr){
        int pairCount = 0;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == -1){
                continue;
            }
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] == -1){
                    continue;
                }

                if(isRecycledPairs(arr[i], arr[j])){
                    pairCount++;
                    arr[i] = arr[j] = -1;
                }
            }

        }

        return pairCount;
    }
}
