public class Tower_Of_Hanoi {
    public static void TOH(int n,String src, String h,String destination){
        if(n==1)
        {
            System.out.println("Transfer the disc "+n+" from "+src+" to "+destination);
            return;
        }
        TOH(n-1,src,destination,h);
        System.out.println("Transfer the disc "+n+" from "+src+" to "+h);
        TOH(n-1,h,src,destination);
    }    
    public static void main(String args[]){
        int n=3;
        TOH(n,"A","C","B");
    }
}