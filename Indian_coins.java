public class Indian_coins {
    public static int solution(int[] coins,int amount){
        int ans=0;        
        int coin=0;
        for(int i=coins.length-1;i>=0;i--){
            if(coins[i]<=amount){
                coin=coins[i];
                ans+=amount/coin;
                amount%=coin;
            }                
        }
        return amount==0 ? ans : -1;
    }
    public static void main(String[] args) {
        int[] coins={1,2,5,10,20,50,100,500,1000};
        int amount= 121;
        System.out.println(solution(coins,amount));

    }
}
