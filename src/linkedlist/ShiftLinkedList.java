package linkedlist;

public class ShiftLinkedList {

    static void shift(LinkedNode head, int n) {
        if (n <= 0 || head == null) {
            return;
        }
        LinkedNode second_ptr = head;
        int i = 0;
        while (i < n) {
            if (second_ptr.next == null) {
                second_ptr = head;
            } else {
                second_ptr = second_ptr.next;
            }

            i++;
        }

        LinkedNode first_ptr = head;
        while (second_ptr.next != null) {
            second_ptr = second_ptr.next;
            first_ptr = first_ptr.next;
        }

        second_ptr.next = head;
        head = first_ptr.next;
        first_ptr.next = null;
        head.printList();
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
        n1.printList();
        shift(n1, 7);
    }
}
