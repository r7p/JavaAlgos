package Dataminr;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by rpatel on 5/26/17.
 */
public class PriorityQueueExample {


    public static void main(String[] args) {
        Queue<Integer> pQ = new PriorityQueue<>();

        pQ.add(5);
        pQ.add(15);
        pQ.add(3);
        pQ.add(1);
        pQ.add(25);
        pQ.add(20);

        while (!pQ.isEmpty()) {
            System.out.println(pQ.poll());
        }

    }

}
