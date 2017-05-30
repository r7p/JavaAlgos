package linkedlist.reverse;

import linkedlist.LinkedNode;

/**
 * Created by rpatel on 5/30/17.
 */
public class Recursive {

    public LinkedNode reverseList(LinkedNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        LinkedNode rest = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }

    public static void main(String[] args) {
        LinkedNode a = new LinkedNode("A");
        LinkedNode b = new LinkedNode("B");
        LinkedNode c = new LinkedNode("C");

        a.next = b;
        b.next = c;

        a.printList();
        Recursive x = new Recursive();
        LinkedNode reversed = x.reverseList(a);
        reversed.printList();
        c.printList();
    }
}
