import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] nums;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[m];
        sb = new StringBuilder();

        perm(0);

        System.out.println(sb.toString());
    }

    public static void perm(int cnt) {

        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            nums[cnt] = i;
            perm(cnt+1);
        }
    }
}