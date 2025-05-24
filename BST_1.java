import java.util.ArrayList;

public class BST_1 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(val<root.data){
            root.left=insert(root.left,val);
        }else{
            root.right=insert(root.right,val);
        }
        return root;
    }
    static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    static boolean search(Node root,int key){
        if(root==null){
            return false;
        }if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left,key);
        }else{
            return search(root.right,key);
        }
      
    }
    static Node deleteNode(Node root,int key){
        if(root.data<key){
            root.right=deleteNode(root.right,key);
        }else if(root.data>key){
            root.left=deleteNode(root.left,key);
        }else{
            //case1 leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            //case2 single child
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            //case3 double child
            Node IS=findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=deleteNode(root.right, IS.data);
        }
        return root;
    }
    static Node findInorderSuccessor(Node root){
        if(root.left==null){
            return root;
        }
        return findInorderSuccessor(root.left);

    }
    static void printinrange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data<=k2 && root.data>=k1){
            printinrange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printinrange(root.right, k1, k2);
        }else if(root.data<k1){
            printinrange(root.right, k1, k2);
        }else if(root.data>k2){
            printinrange(root.left, k1, k2);
        }
    }
    static void print2leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            System.out.println(path);
        }

        print2leaf(root.left, path);
        print2leaf(root.right, path);
        path.remove(path.size()-1);

    }
    static boolean isValidBST(Node root,Integer min,Integer max){
        if(root==null){
            return true;
        }
        if((min!=null && root.data<=min) || (max!=null && root.data>=max)){
            return false;
        }
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }
    static class Info {
        boolean isValidBST;
        int size;
        int min;
        int max;
        public Info(boolean isValidBST,int size,int min,int max){
            this.isValidBST=isValidBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxBST=0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max=Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
        if(root.data<=leftInfo.max || root.data>=rightInfo.min){
            return new Info(false,size,min,max);
        }if(leftInfo.isValidBST && rightInfo.isValidBST){
            maxBST=Math.max(maxBST,size);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }
    static void getInorder(Node root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }
    static Node createBST(ArrayList<Integer> arr,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(arr.get(mid));
        root.left=createBST(arr, start, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
    }
    static Node merge2BSTs(Node root1,Node root2){
        //step 1
        ArrayList<Integer> arr1=new ArrayList<>();
        getInorder(root1,arr1);

        //step 2
        ArrayList<Integer> arr2=new ArrayList<>();
        getInorder(root2, arr2);
        int i=0,j=0;
        ArrayList<Integer> merged=new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                merged.add(arr1.get(i));
                i++;
            }else{
                merged.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            merged.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            merged.add(arr2.get(j));
            j++;
        }
        return createBST(merged, 0, merged.size()-1);
    }
    static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        // int values[]={8,5,3,1,4,6,10,11,14};
        // Node root=null;
        // for(int i=0;i<values.length;i++){
        //     root=insert(root,values[i]);
        // }
        //inorder(root);
        //System.out.println(search(root, 7));
        //deleteNode(root, 5);
        //inorder(root);
        //printinrange(root, 5, 10);

        //print2leaf(root, new ArrayList<>());



        // Node root=new Node(50);
        // root.left=new Node(30);
        // root.left.left=new Node(5);
        // root.left.right=new Node(20);


        // root.right=new Node(60);
        // root.right.left=new Node(45);
        // root.right.right=new Node(70);
        // root.right.right.left=new Node(65);
        // root.right.right.right=new Node(80);
        // Info info=largestBST(root);
        // System.out.println("Largest BST size is:"+maxBST);



        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);


        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);
        Node root3=merge2BSTs(root1, root2);
        preorder(root3);

    }

}
