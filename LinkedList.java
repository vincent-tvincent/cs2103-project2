public class LinkedList<T, U> {
    private class node<K, D>{

        public node<K, D> previous, next;
        public K key;
        public D data;

        public node (K key, D data, node<K, D> previous, node<K, D> next){
            this.key = key;
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public node (K key, D data){
           this.key = key;
            this.data = data;
            previous = null;
            next = null;
        }
    }

    public node<T, U> head, tail; // head is the LEFT most (last recent called) one and tail is the RIGHT most (most recent called) one.
    private int capacity;
    private int num;
    public boolean overflow;
    public LinkedList (int capacity) {
        head = null;
        tail = null;
        this.capacity = capacity;
        num = 0;
        overflow = false;
    }

    public node<T, U> addLast(T key, U data){
        num++;
        if(head == null){
            head = new node<T, U> (key, data);
            tail = head;
        }else{
            tail.next = new node<T, U>(key, data, tail, null);
            tail = tail.next;
            if(num > capacity) {
                overflow = true;
            }
        }
        return tail;
    }

    // TODO: create removeLeast() that returns the least called item in the list and updates the head

    /**
     * Remove the least called element in the linked list, and return the data of the node been removed
     * @return the data of the node been removed
     */
    public T removeLeast(){
        T key = head.key;
        head.next.previous = null;
        head = head.next;
        num--;
        if(num <= capacity){
            overflow = false;
        }
        return key;

    }

    // given a node this will return the data it carries and move the node to the tail
    public U getValue(U node){
        node n = (node<T, U>) node;

        // if the called node is the tail we dont need to do anything
        if(tail != n) {
            node prev = n.previous;
            node next = n.next;

            // if node is the head and the next is not null, make it the head
            if(head == n) {
                // if we are not the tail next will never be null
                head = next;
            }

            // connect adjacent nodes
            if(prev != null) {
                prev.next = next;
            }
            next.previous = prev;

            // make node tail
            tail.next = n;
            n.previous = tail;
            n.next = null;
            tail = n;
        }

        return (U) n.data;
    }
}

