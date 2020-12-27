import java.util.NoSuchElementException;

class Queue<T>{
    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;

        }
    }
    private Node<T> first;
    private Node<T> last;

    //끝에다가 data 넣는것
    public void add(T item){
        //아이템을 가지고 node 를 생성
        Node<T> t = new Node<T>(item);
        //마지막 노드가 있다면
        if (last != null){
            //뒤에 새로 생성한 노드 추가
            last.next = t;
        }
        //t를 마지막 노드로 설정
        last = t;
        //데이타가 없을때
        if(first == null){
            first = last;
        }
    }
    //맨앞에서 data 를 꺼내는것
    public T remove(){
        //큐 가 비어있으면
        if (first == null){
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;

        //여기이해안감
        if(first == null){
            last = null;
        }
        //맨앞에 값
        return data;
    }
    public T peek(){
        if (first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }
    public boolean isEmpty(){
        return first == null;
    }
}
public class QueueSt {
    public static void main (String[] args){
        Queue<Integer> q = new Queue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());

    }
}
