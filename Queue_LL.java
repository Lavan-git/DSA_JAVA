public class Queue_LL {
    static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Queue{
        static Node head=null;
        static Node tail=null;
        public static boolean isEmpty(){
            return head==null && tail==null;
        }
        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;            
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        public static int remove(){
            if (isEmpty()) {
                return -1;
            }
            int data = head.data;
            
            if (tail == head) {
                head = tail=null;
            }else{
                head = head.next;
            }
            return data;            
        }
        public static int peek(){
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }   
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove()); 
        q.add(4);
        System.out.println(q.remove()); 
        q.add(5);
        while(!q.isEmpty()){
            System.out.println("Top element is "+q.peek());
            q.remove();
        }
    }
}
