public class LinkedList_Practice2 {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head=newNode;        
    }
    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void printLinkedList(){
        if(head==null){
            System.out.println("The linked list is empty");
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void addInTheMiddle(int index,int data){
        if(index==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        int idx=0;
        Node temp=head;
        while(idx<index-1){
            temp=temp.next;
            idx++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public int removeFirst(){
        if(head==null){
            System.out.println("The linked list is empty");
            return -1;
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
        if(head==null){
            System.out.println("The linked list is empty");
            return -1;
        }else if(size==1){
            int value=head.data;
            head=tail=null;
            size--;
            return value;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;            
        }
        int value=temp.next.data;
        temp.next=null;
        tail=temp;
        size--;
        return value;
    }
    public int iterativeSearch(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key)
                return i;
            temp=temp.next;
            i++;
        }
        return -1;
    }
    public int recursiveSearchHelper(Node head,int key){
        if(head==null){
            return -1;
        }else if(head.data==key){
            return 0;
        }
        int index= recursiveSearchHelper(head.next, key);
        if(index==-1){
            return -1;
        }else{
            return index+1;
        }
    }
    public int recursiveSearch(int key){
        return recursiveSearchHelper(head, key);
    }
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;      
        }
        head=prev;

    }
    public void deleteNthFromEnd(int n){
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head=head.next;
            return;
        }
        int i=1;
        int idxToFind=sz-n;
        Node prev=head;
        while(i<idxToFind){
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return;
    }
    public static void main(String[] args) {
        LinkedList_Practice2 ll=new LinkedList_Practice2();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addInTheMiddle(2, 9);
        System.out.println(ll.removeLast());
        ll.printLinkedList();
        ll.reverse();
        ll.printLinkedList();
        //System.out.println(ll.size);
        //System.out.println(ll.recursiveSearch(1));
    }
}
