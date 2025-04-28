import java.io.*;
import java.util.*;

public class Main {
    static int x;
    static char[] arr;
    static boolean[] isSelected;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        String str = String.valueOf(x);

        arr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        isSelected = new boolean[str.length()];
        min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        backTracking(sb, 0);
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        }else {
            System.out.println(min);
        }
    }

    public static void backTracking(StringBuilder sum, int idx) {
        if (idx == arr.length) {
            int num = Integer.parseInt(sum.toString());
            if (num > x) {
                min = Math.min(min, num);
            }
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if (!isSelected[i]) {
                isSelected[i ]= true;
                sum.append(arr[i]);
                backTracking(sum, idx+1);
                sum.deleteCharAt(sum.length() - 1);
                isSelected[i] = false;
            }
        }
    }
}