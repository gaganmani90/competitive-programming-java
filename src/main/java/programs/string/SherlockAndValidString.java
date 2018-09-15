package programs.string;

/**
 * @see <a href="https://tinyurl.com/yac9fnsa">Hackerrank</a>
 * @author gagamani
 * @date 9/15/18
 */
public class SherlockAndValidString {

    public static boolean isValid(String str){
        int[] count = new int[256];


        for(char c : str.toCharArray()){
            count[c]++;
        }

        int firstCharCount = count[str.charAt(0)];
        for(int i = 0; i < count.length; i++){
            //get count of first character

            //subtract first char count from each of the char count
            //It should either leave count array with all zeros or only with one 1 (for valid string)
            if(count[i] != 0){
                count[i] = Math.abs(count[i] - firstCharCount);
            }
        }

        int sum = 0;
        for(int i = 0; i < count.length; i++){
            sum += count[i];
        }

        if(sum == 0 || sum == 1){
            return true;
        }
        else if(Math.abs(firstCharCount - sum) == 1) { //edge case
            return true;
        }
        return false;
    }
}
