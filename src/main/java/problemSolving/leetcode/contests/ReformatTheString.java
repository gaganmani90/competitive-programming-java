package problemSolving.leetcode.contests;

import java.util.ArrayList;
import java.util.List;

public class ReformatTheString {
    public static String reformat(String s) {
        List<Character> digits = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        boolean isNextLetter = false;
        char[] arr = new char[s.length()];

        createDigitsAndLettersList(digits, letters, s);

        int digitIndex = 0;
        int letterIndex = 0;
        int diff = Math.abs(digits.size() - letters.size());
        //edge case
        if(diff > 1) {
            return "";
        }

        //initialize
        if(digits.size() > letters.size()) {
            arr[0] = digits.get(0);
            isNextLetter = true;
            digitIndex++;
        } else {
            arr[0] = letters.get(0);
            letterIndex++;
        }

        for(int i = 1; i < arr.length; i++) {
            if(isNextLetter) {
                arr[i] = letters.get(letterIndex++);
                isNextLetter = false;
            } else {
                arr[i] = digits.get(digitIndex++);
                isNextLetter = true;
            }
        }


        return String.copyValueOf(arr);
    }

    private static void createDigitsAndLettersList(List<Character> digits, List<Character> letters, String s) {
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)){
                digits.add(c);
            } else if(Character.isLetter(c)) {
                letters.add(c);
            }
        }
    }

}
