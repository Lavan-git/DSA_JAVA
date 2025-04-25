public class kth_largest_odd_number_in_given_range {
    public static int find_kth_largest_odd_number(int range[],int k){
        int L=range[0];
        int R=range[1];
        if(k<=0){
            return 0;
        }
        if((R & 1)>0){
            int count=(int)Math.ceil((R-L+1)/2);
            if(count<k){
                return 0;
            }else{
                return R-2*k+2;
            }
        }else{
            int count=(R-L+1)/2;
            if(count<k){
                return 0;
            }else{
                return R-2*k+1;
            }
        }
    }
    public static void main(String[] args) {
        int range[]={-5,5};
        int k=2;
        int kth_largest_odd_number=find_kth_largest_odd_number(range,k);
        System.out.println(kth_largest_odd_number);
    }
}
