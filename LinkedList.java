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

    public node<T> head, tail; // head is the LEFT most (last recent called) one and tail is the RIGHT most (most recent called) one.
    private int capacity;
    private int num;
    public boolean filled;
    public LinkedList (int capacity){
        head = new node<T>(null);
        tail = head;
        this.capacity = capacity;
        num = 0;
        filled = false;
    }

    public node<T> addLast(T data){
        num++;
        if(head == null){
            head = new node<T> (data, null, null);
            tail = head;
        }else{
            tail.next = new node<T>(data,tail, null);
            tail = tail.next;
            // TODO: we can set filled here however removing elements need to be done in another method
            if(num > capacity){
                head.next.previous = null;
                num--;
                filled = true;
            }
        }
        return tail;
    }

    // TODO: create removeLeast() that returns the least called item in the list and updates the head

    public T getValue(T node){
        node n = (node<T>) node;
        return (T) n.data;
    }
}

