package algorithms.msft;

import java.time.LocalDate;
import java.time.Month;

/**There is a string representing a date in "MM-DD" format, where MM denotes a month in a two-digit format and DD denotes a day in a two-digit format. Some digits were replaced by "?". Replace all the question marks with digits (0-9) in such a way as to obtain the latest possible date.
 Assume that the maximum number of days in each month is as follows:
 mm | month | number of days
 01 | January | 31
 02 | February | 28
 03 | March | 31
 04 | April | 30
 05 | May | 31
 06 | June | 30
 07 | July | 31
 08 | August | 31
 09 | September | 30
 10 | October | 31
 11 | November | 30
 12 | December | 31
 • Write a function:
 public String solution(String date);

 that, given a string date, returns the latest valid date as a string in the format "MM- DD". If it is not possible to obtain any valid date, return the string "xx-xx".

 Examples:

 Assuming date = "?1-31", the date is clearly from January (01) or November (11). Only January has 31 days, so the function should return "01-31".
 Assuming date = "02-??", the date is clearly from February (02), which has 28 days. The function should return "28-02".
 Assuming date = "??-4?", no month has at least 40 days. The function should return "XX-xx".
 Assuming date = "09-31", the date is not valid. There are only 30 days in September, so the function should return "XX-Xx".
 Assume that:
 • date consists of exactly five characters; the third one is "-", the others are digits (0-9) or "?".
 */
public class GuessTheDate {
    public static String solution(String date) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < date.length(); i++) {
            char c = date.charAt(i);
            if (c == '?') {
                if (i == 0) {
                    result.append("2"); // First digit of month can be 0 or 1
                } else if (i == 1) {
                    if (result.charAt(0) == '0' || result.charAt(0) == '1') {
                        result.append("9"); // Second digit of month can be 0-9 if first digit is 0 or 1
                    } else {
                        result.append("3"); // Second digit of month can be 0-3 if first digit is 2
                    }
                } else if (i == 3) {
                    result.append("3"); // First digit of day can be 0-3
                } else if (i == 4) {
                    result.append("9"); // Second digit of day can be 0-9
                }
            } else {
                result.append(c);
            }
        }

        int month = Integer.parseInt(result.substring(0, 2));
        int day = Integer.parseInt(result.substring(3, 5));

        if (month == 0 || month > 12 || day == 0 || day > getDaysInMonth(month)) {
            return "XX-xx"; // Invalid date
        }

        return result.toString();
    }

    public static int getDaysInMonth(int month) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return daysInMonth[month];
    }
    public static void main(String[] args) {
        System.out.println(solution("?1-31")); // Output: "01-31"
        System.out.println(solution("02-??")); // Output: "28-02"
        System.out.println(solution("??-4?")); // Output: "XX-xx"
        System.out.println(solution("09-31")); // Output: "XX-Xx"
    }
}
