public class Trie_prefix_problem {
    public static class Node{
        Node children[]=new Node[26];
        int freq=0;
        boolean EOW=false;
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
            curr.freq++;

        }
        curr.EOW=true;
    }
    public static boolean search(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.EOW==true;
    }
    public static String findPrefix(String word){
        Node curr=root;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            str.append(word.charAt(i));
            curr=curr.children[idx];
            if(curr.freq==1){
                break;
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        root=new Node();
        String arr[]={"zebra","dog","dove","duck"};
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        String res[]=new String[arr.length];
        int id=0;
        for(String word:arr){
            res[id++]=findPrefix(word);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
