import java.util.ArrayList;

public class Arraylist_pairsum2_2pointer {
    public static boolean pairsum2(ArrayList<Integer> list,int target){
        int lp=0;int rp=0;
        int n=list.size();
        for(int i=0;i<n-1;i++){
            if(list.get(i)>list.get(i+1)){
                rp=i;
                lp=i+1;
            }
        }
        while(lp!=rp) {

            if((list.get(lp)+list.get(rp))>target){
                rp=(n+rp-1)%n;
            }else if((list.get(lp)+list.get(rp))==target){
                System.out.println("("+list.get(lp)+","+list.get(rp)+")");
                return true;
            }
            else{lp=(lp+1)%n;}

        }
        return false;

    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(pairsum2(list, 17));
    }
}
