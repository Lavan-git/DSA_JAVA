public class Maximum_balanced_string_partitions {
    public static void main(String[] args) {
        String str="LRRRRLLRLLRL";
        int n=str.length();
        int Lcount=0;
        int Rcount=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='L'){
                Lcount++;
            }
            else if(str.charAt(i)=='R'){
                Rcount++;
            }
            if(Lcount!=0 && Rcount!=0 && Lcount==Rcount){
                ans++;
                Lcount=0;
                Rcount=0;
            }

        }
        System.out.println(ans);
    }
}
