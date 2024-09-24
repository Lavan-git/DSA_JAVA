import java.util.Scanner;
//22BDS0047
public class Lrc_Vrc {
    public static void lrc(String temp[][]) {
        int count;
        for (int j = 0; j < temp[0].length - 1; j++) {
            count = 0;
            for (int i = 0; i < temp.length - 1; i++) {
                if (temp[i][j].equals("1")) {
                    count += 1;
                }
            }
            if (count % 2 == 0) {
                temp[temp.length - 1][j] = "0";
            } else {
                temp[temp.length - 1][j] = "1";
            }
        }
    }

    public static void vrc(String temp[][]) {
        for (int i = 0; i < temp.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < temp[0].length - 1; j++) {
                if (temp[i][j].equals("1")) {
                    count += 1;
                }
            }
            if (count % 2 == 0) {
                temp[i][temp[0].length - 1] = "0";
            } else {
                temp[i][temp[0].length - 1] = "1";
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp[][] = new String[5][9];
        System.out.println("Enter the 8-bit binary messages:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                temp[i][j] = sc.next();
            }
        }

       
        for (int i = 0; i < 4; i++) {
            temp[i][8] = "X";  
        }
        for (int j = 0; j < 9; j++) {
            temp[4][j] = "X"; 
        }

        vrc(temp);
        lrc(temp);

        System.out.println("\nMessage          VRC");
        System.out.println("------------------");

     
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.print("| " + temp[i][8]); 
            System.out.println();
        }

        System.out.println("------------------");
        System.out.print("LRC    ");
        for (int j = 0; j < 8; j++) {
            System.out.print(temp[4][j] + " ");
        }
        System.out.println();

        sc.close();
    }
}
