public class String_Compression {
    public static String compression(String str){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<str.length();i++){
            Integer count=1;            
            while(i<str.length()-1 && str.charAt(i+1)==str.charAt(i)){                
                count++;
                i++;               
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }            
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str="abbbbc";
        System.out.println("The compressed string is: "+compression(str));
    }
}
