import java.util.*;

public class Merge_intervals {
    public static void main(String[] args) {
        int intervals[][]={{1,3},{2,6},{8,10},{15,18}};
        Arrays.sort(intervals,((a,b)->Integer.compare(a[0],b[0])));
        List<int []> x=new ArrayList<>();
        int current[]=intervals[0];
        for(int i=1;i<intervals.length;i++){
            int next[]=intervals[i];
            if(current[1]>=next[0]){
                current[1]=Math.max(current[1],next[1]);
            }else{
                x.add(current);
                current=next;
            }
        }
        x.add(current);
        for(int i[]:x){
            System.out.println(i[0]+" "+i[1]);
        }
        x.toArray();
    }
}
