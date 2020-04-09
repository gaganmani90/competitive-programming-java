package problemSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier,
 * with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *
 *
 * Constraints:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 *
 */
public class ReorderDatalogFiles {
    /**
     * @param logs
     * @return
     */
    public static String[] reorderLogFiles(String[] logs) {
        List<Log> sortedLogs = new ArrayList<>();
        for(String log : logs) {
            String[] words = log.split(" ",2); //identifier and rest of the string
            sortedLogs.add(new Log(words[0], words[1]));
        }
        Collections.sort(sortedLogs, new LogComparator());
        return convertToArray(sortedLogs);
    }

    private static String[] convertToArray(List<Log> logs) {
        String[] logsArr = new String[logs.size()];
        int i = 0;
        for(Log log : logs) {
            logsArr[i++] = log.toString();
        }
        return logsArr;
    }
}

enum LogType {
    DIGIT(0), LETTER(1);
    int value;
    LogType(int value) {
        this.value = value;
    }
}
/**
 * Example: "dig1 8 1 5 1" -> identifier = dig1, logs = [8 1 5 1]
 */
class Log {
    String identifier;
    LogType type = LogType.LETTER;
    String logs;

    public Log(String identifier, String logs){
        this.identifier = identifier;
        this.logs = logs;
        //set log type
        if(isDigit(logs.charAt(0))){
            this.type = LogType.DIGIT;
        }
    }

    private boolean isDigit(char c) {
        int cInt = Character.digit(c, 10);
        if(cInt >= 0 && cInt <=9) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.identifier + " " + this.logs;
    }
}

class LogComparator implements Comparator<Log> {

    /**
     * Reorder the logs so that all of the letter-logs come before any digit-log.
     * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
     * The digit-logs should be put in their original order.
     * @param l1
     * @param l2
     * @return
     */
    @Override
    public int compare(Log l1, Log l2) {
        //compare letter-logs
        if(l1.type.equals(LogType.LETTER) && l2.type.equals(LogType.LETTER)){
            int compareResult = l1.logs.compareTo(l2.logs);
            return (compareResult == 0) ? l1.identifier.compareTo(l2.identifier) : compareResult;
        }
        //compare digit-logs
        else if (l1.type.equals(LogType.DIGIT) && l2.type.equals(LogType.DIGIT)){
            return 0;
        }
        return l2.type.value - l1.type.value; //compare digit and letter logs
    }
}
