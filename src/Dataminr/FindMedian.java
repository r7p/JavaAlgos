package Dataminr;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by rpatel on 5/26/17.
 */
public class FindMedian {

    Queue<Integer> min = new PriorityQueue<>();
    Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    void addNum(int num) {
        //add number to max heap
        max.offer(num);

        //take top most number from max heap (which will be max number)
        //and add it to min heap
        min.offer(max.poll());

        if (max.size() < min.size()) {
            //if heaps are unbalance, take lowest number (top most from min heap)
            //and add to max heap
            max.offer(min.poll());
        }

    }

    double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        else return max.peek();
    }

    public static void main(String[] args) {
        FindMedian x = new FindMedian();
        x.addNum(5);
        System.out.println("Median is " + x.findMedian());
        x.addNum(15);
        System.out.println("Median is " + x.findMedian());
        x.addNum(1);
        System.out.println("Median is " + x.findMedian());
        x.addNum(3);
        System.out.println("Median is " + x.findMedian());
        x.addNum(25);
        System.out.println("Median is " + x.findMedian());
        x.addNum(20);
        System.out.println("Median is " + x.findMedian());
    }
}
