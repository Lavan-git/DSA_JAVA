import java.util.*;
public class Chocola_problem {
    public static void main(String[] args) {
        int n=4;
        int m=6;
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());
        int h=0;int v=0;
        int hp=1;int vp=1;
        int cost=0;
        while(h<n-1 && v<m-1){
            //vertical cost is less
            if(costVer[v]<=costHor[h]){
                cost+=costHor[h]*vp;
                h++;
                hp++;
            }else{
                cost+=costVer[v]*hp;
                v++;
                vp++;
            }
        }
        while(h<n-1){
            cost+=costHor[h]*vp;
            h++;
            hp++;
        }
        while(v<m-1){
            cost+=costVer[v]*hp;
            v++;
            vp++;
        }
        System.out.println("The min cost is:"+cost);
    }
}
