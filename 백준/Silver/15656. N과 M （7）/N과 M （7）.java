import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] nums;
    static int[] result;
    static boolean[] isUsed;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        result = new int[m];
        isUsed = new boolean[n];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        perm2(0);
        System.out.println(sb.toString());
    }

    public static void perm2(int cnt) {

        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            result[cnt] = nums[i];
            perm2(cnt+1);
        }
    }
}