package linkedlist;

/**
 * Find middle node of linked list.  This can be used to middle of the linked list
 */
public class FindMiddle {

    LinkedNode findMiddle(LinkedNode head) {
        if (head == null) {
            return head;
        }

        LinkedNode fast_ptr = head, slow_ptr = head;

        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        return slow_ptr;
    }

    /**
     * Delete node in linked list, without using previous node reference to this node.
     * This doesn't work on last node of the list
     *
     * @param middle
     */
    void deleteMiddleNode(LinkedNode middle) {
        //copy the next node to this middle node, delete next node
        LinkedNode nextNode = middle.next;
        middle.data = nextNode.data;
        middle.next = nextNode.next;
        //nextNode = null;
    }

    public static void main(String[] args) {
        LinkedNode n1 = new LinkedNode("D");
        LinkedNode n2 = new LinkedNode("B");
        LinkedNode n3 = new LinkedNode("A");
        LinkedNode n4 = new LinkedNode("J");
        LinkedNode n5 = new LinkedNode("F");
        LinkedNode n6 = new LinkedNode("G");

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        FindMiddle x = new FindMiddle();
        n1.printList();
        LinkedNode middle = x.findMiddle(n1);
        System.out.println("Middle is " + middle.data);
        System.out.println();

        LinkedNode n7 = new LinkedNode("G");
        n6.next = n7;
        n1.printList();
        middle = x.findMiddle(n1);
        System.out.println("Middle is " + middle.data);
        System.out.println();

        x.deleteMiddleNode(middle);
        n1.printList();
    }
}
