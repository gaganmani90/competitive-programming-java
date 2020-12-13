package problemSolving.leetcode.contests.dec;

import org.junit.Assert;

/**
 * https://leetcode.com/contest/weekly-contest-219/problems/count-of-matches-in-tournament/
 * <p>
 * <p>
 * 5625. Count of Matches in Tournament
 * User Accepted:84
 * User Tried:89
 * Total Accepted:84
 * Total Submissions:91
 * Difficulty:Easy
 * You are given an integer n, the number of teams in a tournament that has strange rules:
 * <p>
 * If the current number of teams is even, each team gets paired with another team. A total of n / 2 matches are played, and n / 2 teams advance to the next round.
 * If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired. A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
 * Return the number of matches played in the tournament until a winner is decided.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 7
 * Output: 6
 * Explanation: Details of the tournament:
 * - 1st Round: Teams = 7, Matches = 3, and 4 teams advance.
 * - 2nd Round: Teams = 4, Matches = 2, and 2 teams advance.
 * - 3rd Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
 * Total number of matches = 3 + 2 + 1 = 6.
 * Example 2:
 * <p>
 * Input: n = 14
 * Output: 13
 * Explanation: Details of the tournament:
 * - 1st Round: Teams = 14, Matches = 7, and 7 teams advance.
 * - 2nd Round: Teams = 7, Matches = 3, and 4 teams advance.
 * - 3rd Round: Teams = 4, Matches = 2, and 2 teams advance.
 * - 4th Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
 * Total number of matches = 7 + 3 + 2 + 1 = 13.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 200
 */
public class CountOfMatches {
    public static int numberOfMatches(int n) {
        int count = 0;
        int matches = matchesPlayed(n);
        int numberOfTeams = n;

        while(matches >= 1) {
            count += matches;
            numberOfTeams = nextRoundTeams(numberOfTeams);
            matches = matchesPlayed(numberOfTeams);
        }

        return count;
    }

    private static int matchesPlayed(int n) {
        return n % 2 == 0 ? n / 2 : (n - 1) / 2;
    }

    private static int nextRoundTeams(int n) {
        return n % 2 == 0 ? n / 2 : (n - 1) / 2 + 1;
    }

    public static void main(String[] args) {
        Assert.assertEquals(6, CountOfMatches.numberOfMatches(7));
        Assert.assertEquals(13, CountOfMatches.numberOfMatches(14));
    }
}
