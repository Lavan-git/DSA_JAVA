import java.util.*;

public class TreeView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            String val = sc.next();
            arr[i] = val.equals("null") ? null : Integer.parseInt(val);
        }

        System.out.println("Right View: " + getRightView(arr));
        System.out.println("Left View: " + getLeftView(arr));

        sc.close();
    }

    public static List<Integer> getRightView(Integer[] arr) {
        List<Integer> rightView = new ArrayList<>();
        int level = 0, index = 0;

        while (index < arr.length) {
            int last = -1;
            for (int i = 0; i < (1 << level) && index < arr.length; i++, index++) {
                if (arr[index] != null) {
                    last = arr[index];
                }
            }
            if (last != -1) rightView.add(last);
            level++;
        }
        return rightView;
    }

    public static List<Integer> getLeftView(Integer[] arr) {
        List<Integer> leftView = new ArrayList<>();
        int level = 0, index = 0;

        while (index < arr.length) {
            int first = -1;
            for (int i = 0; i < (1 << level) && index < arr.length; i++, index++) {
                if (arr[index] != null && first == -1) {
                    first = arr[index];
                }
            }
            if (first != -1) leftView.add(first);
            level++;
        }
        return leftView;
    }
}
