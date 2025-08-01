import java.util.LinkedList;
import java.util.ArrayList;
public class HashMapTemplate {
    static class HashMap<K, V> { //Generic HashMap class
        private class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n;//n
        private int N;
        private LinkedList<Node> buckets[];       
        
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int hc=key.hashCode();
            return Math.abs(hc)%N;
        }
        public int SearchInLL(K key,int bi){
            LinkedList<Node> ll=buckets[bi];
            int di=0;
            for(int i=0;i<ll.size();i++){
                Node node=ll.get(i);
                if(node.key==key){
                    return di;
                }di++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuck[]=buckets;
            buckets=new LinkedList[N*2];
            N*=2;
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<>();
            }

            // add nodes in bucket
            for(int i=0;i<oldBuck.length;i++){
                LinkedList<Node> ll=oldBuck[i];
                for(int j=0;j<ll.size();j++){
                    Node node=ll.get(j);
                    put(node.key,node.value);
                }
            }
        }
        public void put(K key,V value){
            int bi=hashFunction(key);
            int di=SearchInLL(key,bi);
            if(di!=-1){
                Node node=buckets[bi].get(di);
                node.value=value;
            }else{
                buckets[bi].add(new Node(key,value));
                n++;
            }
            double lambda=(double)n/N;
            if(lambda>2.0){
                rehash();
            }
        }
        public boolean containsKey(K key){
            int bi=hashFunction(key);
            int di=SearchInLL(key,bi);
            if(di!=-1){
                return true;
            }else{
                return false;
            }
        }
        public V get(K key){            
            int bi=hashFunction(key);
            int di=SearchInLL(key,bi);
            if(di!=-1){
                Node node=buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }
        public V remove(K key){
            int bi=hashFunction(key);
            int di=SearchInLL(key,bi);
            if(di!=-1){
                Node node=buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll=buckets[i];
                for(Node node:ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String[] args) {
       HashMap<String,Integer> hm=new HashMap<>();
       hm.put("India", 100);
       hm.put("China", 10);
       hm.put("atlanta", 200);
       hm.put("arabia", 1);

       ArrayList<String> keys=hm.keySet();
       System.out.print(keys);
       System.out.println(hm.remove("India"));
       System.out.println(hm.get("India"));
    }
}