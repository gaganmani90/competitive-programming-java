package programs.bitwise;

/**
 *
 * Count number of set bits in a given integer
 * i.e. if input is 3 then output would be 2 [0011 -> 2]
 * @author gagamani
 * @date 9/10/18
 */
public class CountSetBits {

    public static int bits(int num){
        int count = 0;
        while(num != 0){
            count += (num & 1);
            num = num >> 1;
        }
        return count;
    }
}
