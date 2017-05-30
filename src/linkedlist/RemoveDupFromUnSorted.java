package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove duplicate element from un sorted linked list
 */
public class RemoveDupFromUnSorted {

    void removeDup(LinkedNode head) {
        Set<String> dataSet = new HashSet<>();

        LinkedNode curNode = head, prevNode = null;
        while (curNode != null) {
            if (dataSet.contains(curNode.data)) {
                //duplicate node, remove
                prevNode.next = curNode.next;
            } else {
                dataSet.add(curNode.data);
                prevNode = curNode;
            }
            curNode = curNode.next;
        }

    }

    public static void main(String[] args) {
        LinkedNode n1 = new LinkedNode("D");
        LinkedNode n2 = new LinkedNode("B");
        LinkedNode n3 = new LinkedNode("A");
        LinkedNode n4 = new LinkedNode("A");
        LinkedNode n5 = new LinkedNode("F");
        LinkedNode n6 = new LinkedNode("G");

       n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;

       n1.printList();
       RemoveDupFromUnSorted x = new RemoveDupFromUnSorted();
       x.removeDup(n1);
       n1.printList();

        LinkedNode o1 = new LinkedNode("D");
        LinkedNode o2 = new LinkedNode("D");

        o1.next = o2;
        o1.printList();
        x.removeDup(o1);
        o1.printList();

        LinkedNode n7 = new LinkedNode("G");
        n6.next = n7;
        n1.printList();
        x.removeDup(n1);
        n1.printList();
    }
}
