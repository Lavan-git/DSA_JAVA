public class DoubleLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail=newNode;
            size++;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        size++;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail=newNode;
            size++;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
        size++;
    }
    public int removeFirst(){
        if(head == null) return Integer.MIN_VALUE;
        if(head == tail) {
            int temp = head.data;
            head = tail = null;
            size--;
            return temp;
        }
        int temp=head.data;
        head = head.next;
        size--;
        return temp;
    }
    public int removeLast(){
        if(head == null) return Integer.MIN_VALUE;
        if(head == tail) {
            int temp = head.data;
            head = tail = null;
            size--;
            return temp;
        }
        int temp=tail.data;
        tail=tail.prev;
        tail.next=null;
        size--;
        return temp;
    }
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next;
        while(current!=null){
            next = current.next;
            current.next=prev;
            current.prev=next;
            prev=current;
            current=next;
        }
        head=prev;
    }
    public static void main(String[] args) {
        DoubleLL dll=new DoubleLL();
        dll.addFirst(0);
        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(3);
        //System.out.println(dll.removeFirst());
        //System.out.println(dll.removeLast());
        dll.print();
        dll.reverse();
        dll.print();
    }
}
