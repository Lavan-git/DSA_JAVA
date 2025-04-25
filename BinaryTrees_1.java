import java.util.*;

public class BinaryTrees_1 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;

        }
        public static void preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            if(root==null){
                return;
            }

            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelorder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break; 
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static int heightofTree(Node root){
            if(root==null){
                return 0;
            }
            int leftHeight=heightofTree(root.left);
            int rightHeight=heightofTree(root.right);
            return Math.max(leftHeight, rightHeight)+1;
        }
        public static int countofNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftNode=countofNodes(root.left);
            int rightNode=countofNodes(root.right);
            return leftNode+rightNode+1;
        }
        public static int sumofNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftSum=sumofNodes(root.left);
            int rightSum=sumofNodes(root.right);
            return leftSum+rightSum+root.data;
        }
        //APPROACH 1
        public static int diameter1(Node root){
            if(root==null){
                return 0;
            }
            int leftDiameter=diameter1(root.left);
            int leftHeight=heightofTree(root.left);
            
            int rightDiameter=diameter1(root.right);
            int rightHeight=heightofTree(root.right);
            
            return Math.max(leftHeight+rightHeight+1, Math.max(leftDiameter, rightDiameter));
        }
        //APPROACH 2
        static class info{
            int height;
            int diameter;
            public info(int height,int diameter){
                this.height = height;
                this.diameter=diameter;
            }
        }
        public static info diameter2(Node root){
            if(root==null){
                return new info(0,0);
            }
            info LeftInfo=diameter2(root.left);
            info RightInfo=diameter2(root.right);
            int ht=Math.max(LeftInfo.height,RightInfo.height)+1;
            int diam=Math.max(Math.max(LeftInfo.diameter, RightInfo.diameter),LeftInfo.height+RightInfo.height+1);
            return new info(ht, diam);
        }

        public static boolean isIdentical(Node root,Node subroot){
            if(root==null && subroot==null){
                return true;
            }else if(root==null || subroot==null || root.data!=subroot.data){
                return false;
            }if(!(isIdentical(root.left, subroot.left))){
                return false;
            }if(!(isIdentical(root.right, subroot.right))){
                return false;
            }
            return true;
        }
        public static boolean isSubtree(Node root,Node subroot){
            if(root==null){
                return false;
            }
            if(root.data==subroot.data){
                if(isIdentical(root,subroot)){
                    return true;
                }
            }
            boolean leftAns=isSubtree(root.left, subroot);
            boolean rightAns=isSubtree(root.right, subroot);
            return leftAns || rightAns;
        }
    }
    static class Info2{
        Node node;
        int hd;//horizontal distance
        public Info2(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topView(Node root){
        //Level order traversal
        Queue<Info2> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        int min=0,max=0;
        q.add(new Info2(root,0));
        q.add(null);
        while(!q.isEmpty()){
            Info2 curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new Info2(curr.node.left, curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info2(curr.node.right, curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }
            }            
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
    public static void KLevel(Node root,int K,int level){
        if(root==null){
            return ;
        }
        if(K==level){
            System.out.print(root.data+" ");
            return ;
        }
        KLevel(root.left,K,level+1);
        KLevel(root.right,K,level+1);
    }
    public static boolean getPath(Node root,int n,ArrayList<Node> path){
        
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }
        boolean leftFound=getPath(root.left, n, path);
        boolean rightFound=getPath(root.right,n,path);
        if(leftFound || rightFound){
            return true;
        }
        path.remove(path.size()-1);
        return false;

    }
    public static Node LCA(Node root,int n1,int n2){     // LOWEST COMMON ANCESTOR APPROACH 1, store 2 paths
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();
        getPath(root,n1,path1);
        getPath(root,n2,path2);
        //loop to get lowest common ancestor
        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i).data!=path2.get(i).data){
                break;
            }
        }
        Node lca=path1.get(i-1);
        return lca;
    }
    public static Node LCA2(Node root,int n1,int n2){
        //LOWEST COMMON ANCESTOR APPROACH 2, use recursion to find LCA
        if(root==null){
            return null;
        }
        if(root.data==n1 || root.data==n2){
            return root;
        }
        Node leftLCA=LCA2(root.left,n1,n2);
        Node rightLCA=LCA2(root.right,n1,n2);
        if(leftLCA==null){
            return rightLCA;
        }
        if(rightLCA==null){
            return leftLCA;
        }
        return root;

    }  
    public static int getDistance(Node root,int n){
        if(root==null){
            return -1;            
        }
        if(root.data==n){
            return 0;
        }
        int left=getDistance(root.left, n);
        int right=getDistance(root.right, n);
        if(left==-1 && right==-1){
            return -1;
        }else{
            return 1+Math.max(left, right);
        }
    }
    public static int minDistance(Node root,int n1,int n2){
        Node lca=LCA2(root, n1, n2);
        int leftDistance=getDistance(lca,n1);
        int rightDistance=getDistance(lca,n2);
        return leftDistance+rightDistance;
    } 
    public static int Kth_Ancestor(Node root,int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int left=Kth_Ancestor(root.left, n, k);
        int right=Kth_Ancestor(root.right, n, k);
        if(left==-1 && right==-1){
            return -1;
        }
        int max=Math.max(left,right);
        if(max+1==k){
            return root.data;
        }
        return max+1;
    }
    public static int transform(Node root){  //TRANSFORM TO A SUM TREE
        if(root==null){
            return 0;
        }
        
        int left=transform(root.left);
        int right=transform(root.right);
        int data=root.data;
        int newLeft=root.left==null?0:root.left.data;
        int newRight=root.right==null?0:root.right.data;
        root.data=newLeft+newRight+left+right;
        return data;
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        
        // int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        //BinaryTree tree=new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println("Root of the tree is "+root.data);
        // System.out.println("Preorder traversal of the tree is ");
        // tree.preorder(root);
        // System.out.println("\nInorder traversal of the tree is ");
        // tree.inorder(root);
        // System.out.println("\nPostorder traversal of the tree is ");
        // tree.postorder(root);
        // System.out.println("\nLevel order traversal of the tree is ");
        // tree.levelorder(root);
        // System.out.println("\nHeight of the tree is "+tree.heightofTree(root));
        // System.out.println("\nNumber of nodes in the tree is "+tree.countofNodes(root));
        // System.out.println("\nSum of nodes in the tree is "+tree.sumofNodes(root));
        // System.out.println("\nDiameter of the tree is "+tree.diameter1(root));
        //System.out.println("The diameter of the tree is "+tree.diameter2(root).diameter);

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);




        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
        

        //System.out.println(BinaryTree.isSubtree(root,subroot));

        //topView(root);
        // int n1=4;
        // int n2=6;
        //KLevel(root, 2, 1);
        
        //System.out.println("The LCA of 4 and 6 is "+LCA2(root,4,6).data);

        
        // System.out.println("The distance between n1 and n2 is:"+minDistance(root, n1, n2));
        // int n=5,k=2;
        // System.out.println("The kth ancestor of node "+n+" is "+Kth_Ancestor(root, n, k));
        transform(root);
        preorder(root);
    }
}
