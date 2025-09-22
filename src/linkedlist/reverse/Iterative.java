package linkedlist.reverse;

import linkedlist.LinkedNode;

/**
 * Reverse linked list using Iterative approach
 */
public class Iterative {

    public void reverseList(LinkedNode head) {
        LinkedNode curNode = head, prevNode = null;

        while (curNode != null) {
            LinkedNode tmp = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = tmp;
        }
    }

    public static void main(String[] args) {
        LinkedNode a = new LinkedNode("A");
        LinkedNode b = new LinkedNode("B");
        LinkedNode c = new LinkedNode("C");

        a.next = b;
        b.next = c;

        a.printList();
        Iterative x = new Iterative();
        x.reverseList(a);
        c.printList();
    }

}
