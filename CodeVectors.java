import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CodeVectors {

    static int[][] H_T = {
        {1, 0, 1},
        {1, 1, 1},
        {1, 1, 0},
        {0, 1, 1},
        {1, 0, 0},
        {0, 1, 0},
        {0, 0, 1}
    };
    public static int[] multiplyByMatrix(int[] vector, int[][] matrix) {
        int[] result = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < vector.length; i++) {
                sum += vector[i] * matrix[i][j];
            }
            result[j] = sum % 2;
        }
        return result;
    }
    public static int hammingDistance(int[] v1, int[] v2) {
        int distance = 0;
        for (int i = 0; i < v1.length; i++) {
            if (v1[i] != v2[i]) {
                distance++;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Set<String> uniqueCodeVectors = new HashSet<>();
        List<int[]> codeVectors = new ArrayList<>();
        for (int i = 0; i < (1 << 7); i++) {
            int[] vector = new int[7];
            for (int j = 0; j < 7; j++) {
                vector[j] = (i >> j) & 1; 
            }
            int[] codeVector = multiplyByMatrix(vector, H_T);
            StringBuilder sb = new StringBuilder();
            for (int val : codeVector) {
                sb.append(val);
            }
            String codeVectorStr = sb.toString();
            if (uniqueCodeVectors.add(codeVectorStr)) {
                codeVectors.add(codeVector);
            }
        }
        System.out.println("Code Vectors and their Hamming Distances:");
        for (int i = 0; i < codeVectors.size(); i++) {
            int[] vec1 = codeVectors.get(i);
            System.out.print("Vector " + (i + 1) + ": ");
            for (int val : vec1) {
                System.out.print(val + " ");
            }
            System.out.println();

            System.out.print("Distances: ");
            for (int j = 0; j < codeVectors.size(); j++) {
                if (i != j) {
                    int[] vec2 = codeVectors.get(j);
                    int distance = hammingDistance(vec1, vec2);
                    System.out.print("Vector " + (j + 1) + ": " + distance + " ");
                }
            }
            System.out.println();
        }
        int minHammingDistance = Integer.MAX_VALUE;
        for (int i = 0; i < codeVectors.size(); i++) {
            for (int j = i + 1; j < codeVectors.size(); j++) {
                int distance = hammingDistance(codeVectors.get(i), codeVectors.get(j));
                if (distance < minHammingDistance) {
                    minHammingDistance = distance;
                }
            }
        }
        System.out.println("\nMinimum Hamming Distance: " + minHammingDistance);
    }
}
