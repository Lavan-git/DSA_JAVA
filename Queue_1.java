public class Queue_1 {
    static class Queue{
        static int rear;
        static int size;
        static int arr[];
        static int front;
        Queue(int n){
            rear = -1;
            front=-1;
            size = n;
            arr = new int[n];
        }
        public static boolean isEmpty(){
            return rear == -1 && front==-1;
        }
        public static boolean isFull(){
            return (rear+1)%size==front;
        }
        public static void add(int data){
            if(isFull()){
                System.out.println("The queue is full");
                return;
            }
            //First element add
            if(front==-1){
                front = 0;
            }
            rear=(rear+1)%size;
            arr[rear] = data;
        }
        
        public static int remove(){
            if(isEmpty()){
                System.out.println("The queue is empty");
                return -1;
            }
            int element=arr[front];
            
            // only 1 element
            if(front==rear){
                rear=front=-1;
            }else{
                front=(front+1)%size;
            }
            return element;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("The queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q=new Queue(3);
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
