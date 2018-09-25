package problemSolving.geekForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *     Consider a big party where a log register for guest’s entry and exit times is maintained.
 *     Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.
 *
 * Example :
 *
 * Input: arrl[] = {1, 2, 9, 5, 5}
 * exit[] = {4, 5, 12, 9, 12}
 * First guest in array arrives at 1 and leaves at 4,
 * second guest arrives at 2 and leaves at 5, and so on.
 *
 * Output: 5
 * There are maximum 3 guests at time 5.
 * </pre>
 *
 * @author gagamani
 * @date 9/25/18
 */
public class MaximumIntervalsOverlap {

    enum EnterStatus {
        ARRIVAL, DEPARTURE
    }

    static int maximumOverlap(int[] arrival, int[] departure) {
        if (arrival.length != departure.length) {
            return -1;
        }

        List<Timeline> timelines = organize(arrival, departure);
        Collections.sort(timelines);

        int people = 0;
        int maxTime = 0;
        int max = Integer.MIN_VALUE;
        for (Timeline timeline : timelines) {
            if (timeline.enterStatus.equals(EnterStatus.ARRIVAL)) {
                people++;
            } else {
                people--;
            }
            if (people > max) {
                max = people;
                maxTime = timeline.time;
            }

        }


        return maxTime;
    }

    private static List<Timeline> organize(int[] arrival, int[] departure) {
        List<Timeline> timelines = new ArrayList<>();

        for (int i = 0; i < arrival.length; i++) {
            timelines.add(new Timeline(arrival[i], EnterStatus.ARRIVAL));
            timelines.add(new Timeline(departure[i], EnterStatus.DEPARTURE));
        }
        return timelines;

    }

    /**
     *
     */
    static class Timeline implements Comparable<Timeline> {
        int time;
        EnterStatus enterStatus;

        public Timeline(int time, EnterStatus enterStatus) {
            this.time = time;
            this.enterStatus = enterStatus;
        }

        @Override
        public int compareTo(Timeline timeObj) {
            if (timeObj.time < time) {
                return 1;
            } else if (timeObj.time > time) {
                return -1;
            } else if (timeObj.time == time) {
                if (enterStatus.ordinal() > timeObj.enterStatus.ordinal()) {
                    return 1;
                } else if (enterStatus.ordinal() < timeObj.enterStatus.ordinal()) {
                    return -1;
                }
            }
            return 0;
        }
    }
}
