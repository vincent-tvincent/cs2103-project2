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
    public T getValue(T node){return null;}
}

