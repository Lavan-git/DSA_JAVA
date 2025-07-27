import java.util.*;

public class Group_Anagrams {
    public static List<List<String>> solution(String strs[]){
        HashMap<String,List<String>> map=new HashMap<>();
        String sortedStrings[]=new String[strs.length];
        List<List<String>> ans=new ArrayList<List<String>>();
        for(int i=0;i<strs.length;i++){
            char ch[]=strs[i].toCharArray();
            Arrays.sort(ch);
            String sorted=new String(ch);
            sortedStrings[i]=sorted;
        }
        for(int i=0;i<sortedStrings.length;i++){
            if(!map.containsKey(sortedStrings[i])){
                map.put(sortedStrings[i],new ArrayList<>());
            }
            map.get(sortedStrings[i]).add(strs[i]);
        }
        for(String temp:map.keySet()){
            ans.add(map.get(temp));
        }
        return ans;
    }
    public static void main(String[] args) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        System.out.print(solution(strs));
    }
}
