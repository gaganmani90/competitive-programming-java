package programs.string;

/**
 * Longest Common Substring in an Array of Strings
 * <pre>
 * Input : grace graceful disgraceful gracefully
 * Output : grace
 * Input : sadness sad sadly
 * Output : sad
 * <pre/>
 * @author gagamani
 * @date 9/12/18
 */
public class LongestCommonSubstring {

    static String longestCommonString(String[] arr){
        String common = "";

        for(int i = 0; i < arr[0].length(); i++){
            for(int j = i+1; j <= arr[0].length(); j++){
                String sub = arr[0].substring(i, j);

                for(int k = 1; k < arr.length; k++){
                    String currString = arr[k];
                    if(!currString.contains(sub)){
                        break;
                    }

                    if(k == arr.length-1 && common.length() < sub.length()){
                        common = sub;
                    }
                }
            }
        }

        return common;

    }
}
