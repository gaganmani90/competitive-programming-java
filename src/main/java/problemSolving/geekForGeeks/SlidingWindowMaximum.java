package problemSolving.geekForGeeks;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * TODO: Optimize
 * <pre>
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 *
 * Examples :
 *
 * Input :
 * arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3
 * Output :
 * 3 3 4 5 5 5 6
 *
 * Input :
 * arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
 * k = 4
 * Output :
 * 10 10 10 15 15 90 90
 * </pre>
 *
 * @author gagamani
 * @date 9/23/18
 */
@Slf4j
public class SlidingWindowMaximum {

    static String slidingMaxArray(int[] arr, int windowSize) {

        if (arr == null || windowSize <= 0) {
            return "";
        }
        int len = arr.length;
        if (windowSize >= len) {
            return Arrays.toString(arr);
        }
        log.info("input: "+Arrays.toString(arr));
        List<Integer> max = new ArrayList<>();
        //store index
        Deque<Integer> q= new ArrayDeque<>();
        for(int i = 0; i < len; i++) {
            //remove numbers out of range k
            if(!q.isEmpty() && q.peek() < i - windowSize + 1) {
                log.info("poll: "+q.peek());
                q.poll();
            }
            //remove smaller numbers in window range as they are useless
            while(!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                log.info("pollLast: "+q.peekLast());
                q.pollLast();
            }
            //q contains index...
            q.offer(i);
            if(i >= windowSize-1) {
                max.add(arr[q.peek()]);
            }
        }

        log.info("result: "+max);
        return max.toString();

    }

    private static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
