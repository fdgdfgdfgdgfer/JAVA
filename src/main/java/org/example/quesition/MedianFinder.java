package org.example.quesition;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    private static PriorityQueue<Integer> max = new PriorityQueue<>((x, y) -> (y - x));
    private static PriorityQueue<Integer> min = new PriorityQueue<>();

    public MedianFinder() {

    }

    public static void addNum(int num) {
        if (max.size() != min.size()) {
            max.add(num);
            min.add(max.poll());
        } else {
            min.add(num);
            max.add(min.poll());
        }

    }

    public static double findMedian() {
        return max.size() != min.size()?max.poll():(min.poll()+max.poll())/2.0;
    }

    public static void main(String[] args) {
        addNum(1);
        addNum(2);

        addNum(3);
        addNum(4);

        addNum(8);

        System.out.println(findMedian());
    }
}
