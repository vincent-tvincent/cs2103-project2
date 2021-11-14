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
    public boolean filled;
    public LinkedList (int capacity) {
        this.capacity = capacity;
        this.num = 0;
        head = new node<T>(null);
        filled = false; // if this turn true, the least called item in hash map should be removed.
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
                filled = true; // let hash map remove one element as well
            }
        }
    }

    public T leastUsedKey(){return head.key;}
}

