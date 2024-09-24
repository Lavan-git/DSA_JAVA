import java.util.*;

public class String_ShortestPath {
    public static double shortest_path(String str){
        int x=0;int y=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='W'){x--;}
            else if(str.charAt(i)=='E'){x++;}
            else if(str.charAt(i)=='N'){y++;}
            else if(str.charAt(i)=='S'){y--;}
            else{return -1;}
        }
        return Math.sqrt(x*x+y*y);
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the direction (N/S/E/W) :");
            String str=sc.next();
            str=str.toUpperCase();
            double len=shortest_path(str);
            if(len<0){
                System.out.println("Error, the direction provided is incorrect :-(");
            }else{
                System.out.println("The shortest distance from origin is: "+len);
            }
        }

    }
}
