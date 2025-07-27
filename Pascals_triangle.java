import java.util.*;;
public class Pascals_triangle {
    public static List<List<Integer>> solution(int numRows){
        List<List<Integer>> ls=new ArrayList<>();
        if(numRows==0){
            return ls;
        }
        List<Integer> firstRow=Arrays.asList(1);
        ls.add(new ArrayList<>(firstRow));
        if(numRows==1){
            return ls;
        }
        List<Integer> secondRow=Arrays.asList(1,1);
        ls.add(new ArrayList<>(secondRow));
        if(numRows==2){
            return ls;
        }
        for(int i=2;i<numRows;i++){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            List<Integer> temp2=ls.getLast();
            for(int j=1;j<i;j++){
                temp.add(temp2.get(j-1)+temp2.get(j));
            }
            temp.addLast(1);
            ls.add(temp);
        }
        return ls;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numRows=sc.nextInt();
        System.out.println(solution(numRows));

    }
}
