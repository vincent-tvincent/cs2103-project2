public class LinkedList<T> {
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
    private node<T> head, tail;

    public LinkedList (){

    }

    public node<T> addFirst(T data){return null;}

    // given a node this will return the data it carries and move the node to the tail
    public T getValue(T node){
        node n = (node<T>) node;

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

        return (T) n.data;
    }
}

