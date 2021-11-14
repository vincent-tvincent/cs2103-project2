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

    public node<T> addFirst(T data){
        num++;
        if(head.data == null){
            head = new node<T> (data, null, null);
            tail = head;
        }else{
            tail.next = new node<T>(data,tail, null);
            tail = tail.next;
            if(num > capacity){
                head.next.previous = null;
                num--;
                filled = true;
            }
        }
        return tail;
    }

    public T getValue(T node){
        node n = (node<T>) node;
        return (T) n.data;
    }
}

