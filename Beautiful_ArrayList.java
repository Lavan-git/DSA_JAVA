import java.util.*;
public class Beautiful_ArrayList {
    public static ArrayList<Integer> solution(int n){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        for(int i=2;i<=n;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(Integer x:result){
                if(2*x<=n){
                    temp.add(2*x);
                }
            }
            for(Integer x:result){
                if(2*x-1<=n){
                    temp.add(2*x-1);
                }
            }
            result=temp;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("Enter n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
