package alg_illuminated;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapMedian {
    // max heap stores smaller numbers than min heal (i.e. H1 heap)
    Queue<Integer> H1 = new PriorityQueue<>(Collections.reverseOrder());

    // min heap stores numbers > max heap (i.e. H2 heap)
    Queue<Integer> H2 = new PriorityQueue<>();

    void addNum(int num) {
        H1.offer(num);

        Integer y = H1.poll();
        H2.offer(y);



        // balance H1 & H2 heaps
        if (H2.size() > H1.size()) {
            H1.offer(H2.poll());
        }
    }

    double findMedian() {
        if (H2.size() == H1.size()) {
            return (H2.peek() + H1.peek()) / 2.0;
        } else {
            return H1.peek();
        }
    }

    public static void main(String[] args) {
        HeapMedian x = new HeapMedian();
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
