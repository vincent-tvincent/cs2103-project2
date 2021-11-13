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
    public T getValue(T node){
        node n = (node<T>) node;

        // if the called node is a head we dont need to do anything
        if(head != n) {
            node prev = n.previous;
            node next = n.next;

            // update tail
            if(tail == n) {
                if(next != null) {
                    tail = next;
                } else {
                    // if we are not the head the prev should never be null
                    tail = prev;
                }
            }

            // connect adjacent nodes
            prev.next = next;
            if(next != null) {
                next.previous = prev;
            }

            // make node head
            head.previous = n;
            n.previous = null;
            n.next = head;
            head = n.next;
        }

        return (T) n.data;
    }
}

