public class LinkedList<U> {
    private class node<T>{

        public node<T> previous, next;
        public T data;

        public node (T data, node<T> previous, node<T> next){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public node (T data){
           this.data = data;
            previous = null;
            next = null;
        }
    }

    public node<U> head, tail; // head is the LEFT most (last recent called) one and tail is the RIGHT most (most recent called) one.
    private int capacity;
    private int num;
    public boolean filled;
    public LinkedList (int capacity){
        head = new node<U>(null);
        tail = head;
        this.capacity = capacity;
        num = 0;
        filled = false;
    }

    public node<U> addLast(U data){
        num++;
        if(head == null){
            head = new node<U> (data, null, null);
            tail = head;
        }else{
            tail.next = new node<U>(data,tail, null);
            tail = tail.next;
            // TODO: we can set filled here however removing elements need to be done in another method
            if(num > capacity){
                removeLeast();
            }
        }
        return tail;
    }

    // TODO: create removeLeast() that returns the least called item in the list and updates the head

    /**
     * Remove the least called element in the linked list, and return the data of the node been removed
     * @return the data of the node been removed
     */
    public U removeLeast(){
        node temp = head;
        head.next.previous = null;
        num--;
        filled = true;
        return (U) temp.data;
    }

    // given a node this will return the data it carries and move the node to the tail
    public U getValue(U node){
        node n = (node<U>) node;

        // if the called node is the tail we dont need to do anything
        if(tail != n) {
            node prev = n.previous;
            node next = n.next;

            // if node is the head and the next is not null, make it the head
            if(head == n) {
                if(next != null) {
                    head = next;
                }
            }

            // connect adjacent nodes
            if(prev != null) {
                prev.next = next;
            }

            if(next != null) {
                next.previous = prev;
            }

            // make node tail
            tail.next = n;
            n.previous = tail;
            n.next = null;
            tail = n;
        }

        return (U) n.data;
    }
}

