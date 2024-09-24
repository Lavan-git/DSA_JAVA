public class trapping_rainwater {
    // public static int rainwater(int array[]){
    //     int lmax[]=new int[array.length];
    //     int rmax[]=new int[array.length];
    //     //calculate left max boundary array        
    //     for(int i=0;i<array.length;i++){
    //         if(i==0){lmax[0]=array[0];}else{           
    //             lmax[i]=Math.max(array[i],lmax[i-1]);}
    //     }
    //     //calculate right max boundary array
    //     for(int j=array.length-1;j>=0;j--){
    //         if(j==array.length-1){rmax[j]=array[j];}else{
    //             rmax[j]=Math.max(array[j], rmax[j+1]);
    //         }
    //      }
    //     //compare left max and right max, find min of it and subtract array index from it.
    //     int count=0;
    //     for(int k=0;k<array.length;k++){
    //         count+=Math.min(lmax[k],rmax[k])-array[k];
    //     }
    //     return count;

    // }


        public static int rainwater(int[] height) {
            int lmax[]=new int[height.length];
            int rmax[]=new int[height.length];
            for(int i=0;i<lmax.length;i++){
                if(i==0){lmax[0]=height[0];}else{
                    lmax[i]=Math.max(height[i],lmax[i-1]);
                }
            }
            for(int j=rmax.length-1;j>=0;j--){
                if(j==rmax.length-1){rmax[j]=height[j];}
                else{
                    rmax[j]=Math.max(height[j],rmax[j+1]);
                }
            }
            int count=0;
            for(int k=0;k<height.length;k++){
                count+=Math.min(lmax[k],rmax[k])-height[k];
            }
            return count;
        }
    
    public static void main(String[] args) {
        int array[]={4,2,0,6,3,2,5};
        int trapped_rainwater=rainwater(array);
        System.out.println("The rainwater trapped is :"+trapped_rainwater);
    }
}
