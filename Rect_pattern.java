
public class Rect_pattern {
    public static void main(String args[]){
        
        int l,b;
        l=10;
        b=7;
        for(int i=0;i<b;i++){
            for(int j=0;j<l;j++){
                if(i==0 || i==b-1 || j==0 || j==l-1){
                    System.out.print("*");
                    continue;
                }
                else{
                    System.out.print(" ");                    
                }
               
                                
            }
            System.out.println();
        }
        
    }
}
