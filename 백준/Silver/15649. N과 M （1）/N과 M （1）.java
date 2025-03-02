import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static boolean[] isSelected;
    static int[] nums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isSelected = new boolean[n+1];
        nums = new int[m];

        perm(0);
    }

    public static void perm(int cnt) {

        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                nums[cnt] = i;
                perm(cnt+1);
                isSelected[i] = false;
            }
        }
    }
}