public class Trie_1 {
    static class Node{
        Node children[]=new Node[26];
        boolean EOW=false;
        Node(){
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
    public static boolean wordBreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }
    public static String ans="";
    public static void longest_word_with_all_prefixes(Node root, StringBuilder temp){
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].EOW==true){
                char ch=(char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longest_word_with_all_prefixes(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }            
        }
    }
    public static void main(String[] args) {
        // String words[]={"the","a","there","their","any","thee"};
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }
        // System.out.println(search("th"));






        // String arr[]={"i","like","samsung","sam","mobile","ice"};
        // for(int i=0;i<arr.length;i++){
        //     insert(arr[i]);
        // }
        // String key="ilikesamsung";
        // System.out.println(wordBreak(key));





        // String str="ababa";
        // for(int i=0;i<str.length();i++){
        //     insert(str.substring(i));
        // }
        // System.out.println(countNodes(root));



        String words[]={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        longest_word_with_all_prefixes(root, new StringBuilder());
        System.out.println(ans);
    }

}
