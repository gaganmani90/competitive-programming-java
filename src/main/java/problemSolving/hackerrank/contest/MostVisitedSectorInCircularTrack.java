package problemSolving.hackerrank.contest;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Most Visited Sector in a Circular Track My SubmissionsBack to Contest
 * User Accepted: 0
 * User Tried: 0
 * Total Accepted: 0
 * Total Submissions: 0
 * Difficulty: Easy
 * Given an integer n and an integer array rounds. We have a circular track which consists of n sectors labeled from 1 to n. A marathon will be held on this track, the marathon consists of m rounds. The ith round starts at sector rounds[i - 1] and ends at sector rounds[i]. For example, round 1 starts at sector rounds[0] and ends at sector rounds[1]
 * <p>
 * Return an array of the most visited sectors sorted in ascending order.
 * <p>
 * Notice that you circulate the track in ascending order of sector numbers in the counter-clockwise direction (See the first example).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 4, rounds = [1,3,1,2]
 * Output: [1,2]
 * Explanation: The marathon starts at sector 1. The order of the visited sectors is as follows:
 * 1 --> 2 --> 3 (end of round 1) --> 4 --> 1 (end of round 2) --> 2 (end of round 3 and the marathon)
 * We can see that both sectors 1 and 2 are visited twice and they are the most visited sectors. Sectors 3 and 4 are visited only once.
 * Example 2:
 * <p>
 * Input: n = 2, rounds = [2,1,2,1,2,1,2,1,2]
 * Output: [2]
 * Example 3:
 * <p>
 * Input: n = 7, rounds = [1,3,5,7]
 * Output: [1,2,3,4,5,6,7]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 100
 * 1 <= m <= 100
 * rounds.length == m + 1
 * 1 <= rounds[i] <= n
 * rounds[i] != rounds[i + 1] for 0 <= i < m
 */
public class MostVisitedSectorInCircularTrack {
    /**
     * @param totalSectors
     * @param rounds
     * @return
     */
    public static List<Integer> mostVisited(int totalSectors, int[] rounds) {
        List<Integer> mostVisited;
        int[] sectorCount = new int[totalSectors]; //count of each sector visit
        int startRound = rounds[0];
        int endRound = 0;

        //sector visit count
        for (int currSectorIndex = 1; currSectorIndex < rounds.length; currSectorIndex++) {
            endRound = rounds[currSectorIndex];
            updateSectorsVisits(startRound, endRound, totalSectors, sectorCount);
            startRound = endRound+1;
        }

        //find max visited sector by eliminating other sectors
        mostVisited = findMaxVisitedSector(sectorCount, totalSectors);


        return mostVisited;

    }

    /**
     * * [4, 5] -> [2]
     * [1, 1, 1, 1, 1, 1, 1] -> [1,2,3,4,5,6,7]
     *
     * @param sectorCount: [2,2,1,1], index 0 is 1st sector, n-1 is nth sector
     * @param n
     * @return
     */
    private static List<Integer> findMaxVisitedSector(int[] sectorCount, int n) {

        int[] sorted = new int[n]; //max array size
        List<Integer> output = new ArrayList<>(); //should contain sector# with max count
        int round = 0;
        // Build the output character array
        // To make it stable we are operating in reverse order.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sectorCount.length; i++) {
            if (sectorCount[i] > max) {
                max = sectorCount[i];
            }
        }

        for (int i = 0; i < sectorCount.length; i++) {
            if (sectorCount[i] == max) {
                output.add(i + 1);
            }
        }


        return output;
    }

    /**
     * update visit count for each marathon
     * @param start start track for a given marathon
     * @param end end track for a given marathon
     * @param max total tracks
     * @param sectorCount array to update
     */
    private static void updateSectorsVisits(int start, int end, int max, int[] sectorCount) {
        if (end < start) {
            for (int i = start; i <= max; i++) {
                sectorCount[i - 1] += 1;
            }
            for (int i = 1; i <= end; i++) {
                sectorCount[i - 1] += 1;
            }

        } else if (end > start) {
            for (int i = start; i <= end; i++) {
                sectorCount[i - 1] += 1;
            }
        } else {
            sectorCount[end - 1] += 1;
        }
    }

    public static void main(String[] args) {
        // Assert.assertEquals();
        Assert.assertEquals("[1, 2]", mostVisited(4, new int[]{1, 3, 1, 2}).toString());
        Assert.assertEquals("[2]", mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}).toString());
        Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7]", mostVisited(7, new int[]{1, 3, 5, 7}).toString());
    }
}
