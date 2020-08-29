package dataStructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> loHeap = new PriorityQueue<>(Comparator.reverseOrder()); //max heap
    PriorityQueue<Integer> hiHeap = new PriorityQueue<>(); //min heap
    int count = 0;
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    /**
     * 1. Add each element to lo max heap first.
     * 2. Move top lo heap element to hi min heap
     * 3. balance heaps
     * @param num
     */
    public void addNum(int num) {
        count++;
        loHeap.add(num);
        hiHeap.add(loHeap.poll()); //get highest from lo heap

        //balance
        if(loHeap.size() < hiHeap.size()) {
            loHeap.add(hiHeap.poll());
        }

        System.out.println("lo heap: "+ loHeap);
        System.out.println("hi heap: "+hiHeap);
    }

    public double findMedian() {
        //even
        if(loHeap.size() == hiHeap.size()) {
            return (double)(loHeap.peek() + hiHeap.peek()) * 0.5;
        }
        return loHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(100);
        medianFinder.addNum(50);
        medianFinder.addNum(200);
        System.out.println(medianFinder.findMedian());
        //medianFinder.addNum(1);
        //medianFinder.addNum(1);
    }
}
