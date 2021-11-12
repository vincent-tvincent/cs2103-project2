public class linkedList<T> {
    private static class node<T>{
        public T key;
        public node<T> previous = null, next = null;

        public node(T key){
            this.key = key;
        }
        public node(T key, node<T> previous, node<T> next){
            this.key = key;
            this.previous = previous;
            this.next = next;
        }
    }
    private node<T> head = new node<T>(null),
            tail = new node<T>(null);

    public linkedList (){
        head.next = tail;
        tail.previous = head;
    }

    public void add(T key){
        if(head.key == null){
            head = new node<T>(key);
            tail = head;
        }else{
            head.next = new node<T> (key, head,null);
        }

    }

    public void removeTail(){
        node<T> temp = tail;
        tail.next.previous = null;
        tail = temp.next;
    }
    public void moveToHead(T key){
        
    }
}
