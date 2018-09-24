package problemSolving.general.bitwise;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * @author gagamani
 * @date 9/24/18
 */
public class AddTwoBinaryNumbers {

    static int add(String n1, String n2) {
        if (StringUtils.isEmpty(n1) && StringUtils.isEmpty(n2)) {
            return 0;
        }

        if (StringUtils.isEmpty(n1)) {
            return binaryToDecimal(Long.parseLong(n2));
        }
        if (StringUtils.isEmpty(n2)) {
            return binaryToDecimal(Long.parseLong(n1));
        }
        Long a = Long.parseLong(n1);
        Long b = Long.parseLong(n2);
        return binaryToDecimal(a) + binaryToDecimal(b);
    }

    /**
     * @param num 15
     * @return "1111"
     */
    static String decimalToBinary(int num) {
        if (num < 0) {
            return "invalid";
        }
        Stack<Integer> binaries = new Stack<>();
        StringBuilder binaryStr = new StringBuilder();
        while (num != 0) {
            int rem = num % 2;
            num = num / 2;
            binaries.push(rem);
        }

        while (!binaries.empty()) {
            binaryStr.append(binaries.pop());
        }
        return binaryStr.toString();
    }

    /**
     * @param binary 1011
     * @return 11
     */
    static int binaryToDecimal(long binary) {

        int decimal = 0;
        int power = 0;
        while (binary != 0) {
            int rem = (int) binary % 2;
            if (rem == 1) {
                decimal += Math.pow(2, power);
            }
            binary = binary / 10;
            power++;

        }
        return decimal;
    }
}
