public class Recursion_Remove_Duplicates {
    public static void RD(String str,int index,StringBuilder newStr,boolean map[]){
        //base
        if(index==str.length()){
            System.out.println(newStr);
            return;
        }
        //kaam
        char currChar=str.charAt(index);
        if(map[currChar-'a']==true){
            RD(str, index+1, newStr, map);
        }else{
            map[currChar-'a']=true;
            RD(str, index+1, newStr.append(currChar), map);
        }
    }
    public static void main(String[] args) {
        String str="youtuberharshitt";
        RD(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
