public class Linked_list_practice {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addLast(int data){

        //STEP-1 CREATE NEW NODE
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void addFirst(int data){

        //STEP-1 CREATE NEW NODE
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //STEP-2 - NEW NODE WILL BE THE HEAD
        newNode.next=head;//link

        //STEP-3 - head is new node
        head=newNode;
    }
    public void addInMid(int index,int data){
        if(index==0){
            addFirst(data);
            return;
        }
        //STEP-1 CREATE NEW NODE
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int count=0;
        while(count<index-1){
            temp=temp.next;
            count++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public void print(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;

        }
        System.out.println("null");
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("List is empty");
            return Integer.MAX_VALUE;
        }else if(size==1){
            int value=head.data;
            head=tail=null;
            size--;
            return value;
        }
        int value=head.data;
        head=head.next;
        size--;
        return value;
    }
    public int removeLast(){
        if(size==0){
            System.out.println("List is empty");
            return Integer.MAX_VALUE;
        }else if(size==1){
            int value=head.data;
            head=tail=null;
            size--;
            return value;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int value=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return value;
    }
    public int iterativeSearch(int key){
        int i=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;    
        }
        return -1;
    }
    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int index=helper(head.next,key);
        if(index==-1){
            return -1;
        }else{
            return index+1;
        }
    }
    public int recursiveSearch(int key){
        return helper(head,key);
    }
    public static void main(String[] args) {
        Linked_list_practice ll=new Linked_list_practice();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addInMid(2, 9);
        System.out.println("Removed First Element is :"+ll.removeFirst());
        System.out.println("Removed Last Element is :"+ll.removeLast());;
        ll.print();
        System.out.println("Size is :"+size);
        System.out.println("The key is found at index:"+ll.recursiveSearch(3));
        System.out.println("The key is found at index:"+ll.iterativeSearch(10));
    }
}
