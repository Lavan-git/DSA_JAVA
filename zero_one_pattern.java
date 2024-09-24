public class zero_one_pattern {
    
    public static void main(String[] args) {
        int x=1;
        for(int i=1;i<6;i++){
            for(int j=0;j<i;j++){
                System.out.print(x); 
                 if(x == 0){
                    x = 1;
                 } else{x=0;}         
                }
                if(i%2!=0){x=0;} else{x=1;} 
                System.out.println();    
            }           
            
        }
    }

