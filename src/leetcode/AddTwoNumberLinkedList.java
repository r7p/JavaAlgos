package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raj on 12/19/2018.
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumberLinkedList {
     static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
            void print() {
                ListNode node = this;
                List<Integer> vals = new ArrayList<>();
                while (node != null) {
                    vals.add(node.val);
                    node = node.next;
                }
                System.out.println(vals);
            }
     }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = null, lastResult = null;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int carry = 0;
        while(node1!=null || node2!=null) {
            int val1 = node1 != null ? node1.val : 0;
            int val2 = node2 != null ? node2.val : 0;
            int sumDigit = (val1 + val2 + carry)%10;
            carry = (val1 + val2 + carry) / 10;
            if (resultHead == null) {
                resultHead = new ListNode(sumDigit);
                lastResult = resultHead;
            } else {
                lastResult.next = new ListNode(sumDigit);
                lastResult = lastResult.next;
            }
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }
        if (carry > 0) {
            lastResult.next = new ListNode(carry);
        }
        return resultHead;
    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(2);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(3);
        n11.next = n12;
        n12.next = n13;

        ListNode n21 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        ListNode n23 = new ListNode(4);
        n21.next = n22;
        n22.next = n23;

        addTwoNumbers(n11, n21).print();

        addTwoNumbers(new ListNode(5), new ListNode(5)).print();

        ListNode a11 = new ListNode(1);
        ListNode a12 = new ListNode(8);
        a11.next = a12;
        ListNode a21 = new ListNode(5);
        addTwoNumbers(a11, a21).print();
    }


}
