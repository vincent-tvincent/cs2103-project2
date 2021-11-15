public class LinkedList<T> {
    private class node{

        public node previous, next;
        public T key;

        public node (T data, node previous, node next){
            this.key = data;
            this.previous = previous;
            this.next = next;
        }

        public node (T data){
           this.key = data;
            previous = null;
            next = null;
        }
    }

    public node head, tail; // head is the LEFT most (last recent called) one and tail is the RIGHT most (most recent called) one.
    private int capacity;
    private int num;
    public boolean filled;
    public LinkedList (int capacity){
        head = new node(null);
        tail = head;
        this.capacity = capacity;
        num = 0;
        filled = false;
    }

    public T add(T data){
        num++;
        if(head == null){
            head = new node (data, null, null);
            tail = head;
        }else{
            tail.next = new node(data,tail, null);
            tail = tail.next;
            // TODO: we can set filled here however removing elements need to be done in another method
            if(num > capacity){
                removeLeast();
            }
        }
        return tail.key;
    }

    // TODO: create removeLeast() that returns the least called item in the list and updates the head

    /**
     * Remove the least called element in the linked list, and return the data of the node been removed
     * @return the data of the node been removed
     */
    public T removeLeast(){
        node temp = head;
        head.next.previous = null;
        num--;
        filled = true;
        return (T) temp.key;
    }

    // given a node this will return the data it carries and move the node to the tail
    public T getValue(T node){
        node n = (node) node;

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

        return (T) n.key;
    }
}

