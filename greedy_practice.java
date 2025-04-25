import java.util.Arrays;
public class greedy_practice{
    public static String Lexicographically_smallest_string_of_length_N_and_sum_K(int N, int K) {
        StringBuilder res=new StringBuilder();
        char[] arr=new char[N];
        Arrays.fill(arr,'a');
        K-=N;
        for(int i=N-1;i>=0;i--){
            if(K<26){
                arr[i]+=K;
                K=0;
            }else{
                arr[i]='z';
                K-=25;
            }
        }
        for(int i=0;i<N;i++){
            res.append(arr[i]);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(Lexicographically_smallest_string_of_length_N_and_sum_K(5,42));
    }
    
}