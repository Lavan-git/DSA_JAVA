import java.util.*;
public class job_sequencing_problem {
    public static int jobScheduling(double[][] jobs) {
        int ans=0;
        //Arrays.sort(jobs,Comparator.comparingInt(s->s[2]));
        Arrays.sort(jobs,Comparator.comparingDouble((double[] s)->s[1]));
        System.out.println(Arrays.deepToString(jobs));
        for(int i=0;i<jobs.length;i++){
            if(i<jobs[i][1]){
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        double[][] jobs={{1, 1, 30}, {2, 3, 40}, {3, 2, 10}};
        System.out.println(jobScheduling(jobs));
    }
}
