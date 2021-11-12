public class LinkedList {

    public Node head;

    public void addFirst(Node n) {
        n.next = head;
        head = n;
    }

    public Node getLast() {
        Node n = head;
        while(n.next != null) {
            n = n.next;
        }
        return  n;
    }

    public void removeLast() {
        Node n = head;
        while(n.next != null) {
            n = n.next;
        }
        n = null;
    }
}
