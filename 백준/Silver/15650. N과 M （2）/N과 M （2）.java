import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static boolean[] isSelected;
    static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isSelected = new boolean[n];
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        comb(0, 0);
    }

    public static void comb(int cnt, int start) {

        if (cnt == m) {
            for (int i = 0; i < n; i++) {
                if (isSelected[i]) {
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        if (start == n) {
            return;
        }

        isSelected[start] = true;
        comb(cnt+1, start+1);
        isSelected[start] = false;
        comb(cnt, start+1);
    }
}