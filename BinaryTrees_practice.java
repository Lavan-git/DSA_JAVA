import java.util.*;

public class BinaryTrees_practice {
    static class Node{
        Node left;Node right;int data;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
    }
    static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    static void inorder(Node root){
        if(root==null){
            return;
        }
        preorder(root.left);
        System.out.print(root.data+" ");
        preorder(root.right);
    }
    static void postorder(Node root){
        if(root==null){
            return;
        }
        
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.data+" ");
    }
    static void levelorder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode!=null){
                System.out.print(currNode.data+" ");
                if(currNode.left!=null)
                    q.add(currNode.left);
                if(currNode.right!=null)
                    q.add(currNode.right);
            }else{
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
        }        
    }
    static int heightofTree(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=heightofTree(root.left);
        int rightHeight=heightofTree(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    static int sumofnodes(Node root){
        if(root==null){
            return 0;
        }
        return sumofnodes(root.left)+sumofnodes(root.right)+root.data;
    }
    
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        //preorder(root);
        //levelorder(root);
        //System.out.println(heightofTree(root));
        //System.out.println("The count of the nodes is:"+countNodes(root));
        System.out.println(sumofnodes(root));
    }
}
