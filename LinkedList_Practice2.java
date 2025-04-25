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
            size--;
            return;
        }
        int i=1;
        int idxToFind=sz-n;
        Node prev=head;
        while(i<idxToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        size--;
        return;
    }
    //Slow fast approach
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        //Step1 Find mid
        Node midNode=findMid(head);
        //Step2 reverse 2nd half
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;//Right half head
        Node left=head;//Left half head
        //Step3 Compare left half and right half    
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }

        return true;
    }
    public boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public void removeCycle(){
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle){
            slow=head;
            Node prev=null;
            while(slow!=fast){
                slow=slow.next;
                prev=fast;
                fast=fast.next;
            }
            prev.next=null;
        }else{
            System.out.println("No cycle detected");
        }
    }
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                temp.next=head1;
                head1=head1.next;
            }else{
                temp.next=head2;
                head2=head2.next;
            }
            temp=temp.next;
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){
        //base case
        if(head==null || head.next==null){
            return head;
        }
        //Step1 find mid
        Node mid=getMid(head);

        //Step2 recursively call for left and right mergeSort
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);

        //Step3 merge left and right sorted linked list
        return merge(newLeft,newRight);
    }
    public void ZigZag(){
        //find mid
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        //reverse 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextLeft,nextRight;
        //alternate merge, zig zag merge
        while(left!=null && right!=null){
            nextLeft=left.next;
            left.next=right;
            nextRight=right.next;
            right.next=nextLeft;
            left=nextLeft;
            right=nextRight;
        }
    }
    public static void main(String[] args) {
        LinkedList_Practice2 ll=new LinkedList_Practice2();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addInTheMiddle(2, 9);
        // //System.out.println(ll.removeLast());
        // ll.printLinkedList();
        // ll.reverse();
        // ll.printLinkedList();
        // ll.deleteNthFromEnd(2);
        // ll.printLinkedList();
        // //System.out.println(ll.size);
        // //System.out.println(ll.recursiveSearch(1));



        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);
        // if(ll.checkPalindrome()){
        //     System.out.println("Is Palindrome");
        // }else{
        //     System.out.println("Not Palindrome");
        // }



        // head=new Node(1);
        // Node temp=new Node(2);
        // head.next=temp;
        // head.next.next=new Node(3);
        // head.next.next.next=temp;

        // System.out.println(isCycle());
        // removeCycle();
        // printLinkedList();
       


        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);
        ll.printLinkedList();
        ll.head=ll.mergeSort(ll.head);
        ll.printLinkedList();
        ll.ZigZag();
        ll.printLinkedList();
    }
}
