package linkedlist;

/**
 * Created by rpatel on 5/30/17.
 */
public class LinkedNode {
    public String data;
    public LinkedNode next;


    public LinkedNode(String data) {
        this.next = null;
        this.data = data;
    }

    public void printList() {
        LinkedNode curNode = this;
        StringBuilder sb = new StringBuilder();
        while (curNode != null) {
            if (sb.length() > 0) {
                sb.append(" -> ");
            }
            sb.append(curNode.data);
            curNode = curNode.next;
        }
        System.out.println(sb.toString());
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("LinkedNode{");
        sb.append("data='").append(data).append('\'');
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
