public class LinkedList<T> {
    private class node<T>{

        public node<T> previous, next;
        public T key;

        public node (T key, node<T> previous, node<T> next){
            this.key = key;
            this.previous = previous;
            this.next = next;
        }

        public node (T data){
           this.key = data;
            previous = null;
            next = null;
        }
    }
    private node<T> head, tail;
    private int capacity, num;
    public boolean expired = false;
    public LinkedList (int capacity) {
        this.capacity = capacity;
        this.num = 0;
        head = new node<T>(null);
    }

    public void add(T key){
        num ++;
        if(head.key == null){
            head = new node<T>(key);
            tail = head;
        }else{
            tail.next = new node<T>(key);
            if(num > capacity){
                head.next.previous = null;
                num--;
                expired = true;
            }
        }

    }

    public T leastUsedKey(){return head.key;}
}

