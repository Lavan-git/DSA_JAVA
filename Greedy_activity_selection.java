import java.util.*;


public class Greedy_activity_selection {
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};

        //sorting
        int activities[][]=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }

        //lambda function -> shortform of big function
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
        
        //end time based sorted
        int maxAct=0;
        ArrayList<Integer> arr=new ArrayList<>();
        maxAct=1;
        arr.add(activities[0][0]);
        int lastEnd=activities[0][2];
        for(int i=1;i<end.length;i++){
            if(activities[i][1]>=lastEnd){
                maxAct++;
                arr.add(activities[i][0]);
                lastEnd=activities[i][2];
            }
        }
        System.out.println("Max activities:"+maxAct);
        System.out.println("Activities selected: "+arr);
    }
}
