package problemSolving.general.bitwise;

/**
 *
 * Count number of bits to be flipped to convert A to B
 *
 * Example:
 * <pre>
 *     Input : a = 10, b = 20
 Output : 4
 Binary representation of a is 00001010
 Binary representation of b is 00010100
 We need to flip highlighted four bits in a
 to make it b.

 Input : a = 7, b = 10
 Output : 3
 Binary representation of a is 00000111
 Binary representation of b is 00001010
 We need to flip highlighted three bits in a
 to make it b.
 * </pre>
 * @author gagamani
 * @date 9/11/18
 */
public class FlipBits {

    public static int flippedBits(int a, int b){
        int xor = a ^ b; //1^0 = 1; 1^1 = 0
        return CountSetBits.bits(xor);
    }
}
