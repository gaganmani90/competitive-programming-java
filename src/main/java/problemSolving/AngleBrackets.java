package problemSolving;

import java.util.HashMap;
import java.util.Stack;

/**
 * input: ><<><
 * output: <><<><>>
 */
public class AngleBrackets {

    private static HashMap<Character, Character> bracketMap = new HashMap<Character, Character>();

    public AngleBrackets() {
        initMap();
    }

    private static void initMap(){
        bracketMap.put('<', '>');
    }
    /**
     *
     *  * input: ><<><
     *  * output: <><<><>>
     * @param brackets
     * @return
     */
    public  String completeBrackets(String brackets) {
        char open = '<';
        char close = '>';
        int openCount = 0, closeCount = 0;
        if(brackets.isEmpty()) {
            return "";
        }
        Stack<Character> bracketStack = new Stack<>();
        for(char c : brackets.toCharArray()){
            if (bracketMap.containsKey(c)){ // '<'
                bracketStack.push(c); //push <
            } else if (bracketStack.isEmpty()){
                openCount++; //need more > angles
            } else  { //its '>' and stack is not empty
                bracketStack.pop();
            }

        }
        closeCount = bracketStack.size(); //we need additional > angles for the remaining >s in stack

        while(openCount-- != 0) {
            brackets = open + brackets;
        }
        while(closeCount-- != 0) {
            brackets = brackets + close;
        }

        return brackets;
    }
}
