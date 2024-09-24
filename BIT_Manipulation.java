public class BIT_Manipulation {
    public static boolean check_odd_even(int a){
        if((a & 1)==0){
            return false;
        }else{
        return true;}
    }
    public static int getBit(int a, int i){
        int bitmask=1<<i;
        if((a & bitmask)==0){
            return 0;
        }else{return 1;}
    }
    public static int setBit(int a,int i){
        int bitmask=1<<i;
        return a | bitmask;
    }
    public static int clearBit(int a,int i){
        int bitmask=~(1<<i);
        return a & bitmask;
    }
    public static int updateBit(int n,int i,int newBit){
        //if(newBit==0){return clearBit(n, i);}else{return setBit(n,i);}
        n=clearBit(n,i);
        int bitmask=newBit<<i;
        return n | bitmask;
    }
    public static int clearLast_i_Bits(int a,int i){
        int bitmask=(~0)<<i;
        return a & bitmask;
    }
    public static int clear_Range_Of_Bits(int n,int i,int j){
        int bitmask=((~0)<<(j+1)) | ((1<<i)-1);
        return n & bitmask;
    }
    public static boolean check_power_of_two(int n){
        return (n & n-1)==0;
       
    }
    public static int count_set_bits_in_a_number(int n){
        int count=0;
        while(n!=0){
            if((n & 1)==1){
                count++;
            }
            n=n>>1;
        }
        return count;

    }
    public static int fast_exponentiation(int a, int n) {
        int ans=1;
        while(n>0){
            if((n & 1)==1){
                ans*=a;
            }
            a*=a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {                
        //System.out.println(getBit(10,3)); 
        //System.out.println(setBit(10,2));
        //System.out.println(clearBit(10,1));   
        //System.out.println(updateBit(10,2,1));   
        //System.out.println(clearLast_i_Bits(10,3));
        //System.out.println(clear_Range_Of_Bits(10, 2, 4));   
        //System.out.println(check_power_of_two(5));
        //System.out.println(count_set_bits_in_a_number(15));
        System.out.println(fast_exponentiation(3,5));
    }
}
