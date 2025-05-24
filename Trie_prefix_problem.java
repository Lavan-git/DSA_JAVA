public class Trie_prefix_problem {
    public class Node{
        Node children[]=new Node[26];
        int freq=0;
        boolean EOW=false;
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
