import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1; // 0도 1가지로 봐야한다.
        int[] tmp = new int[k+1];
        tmp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (coins[i] <= j) {
                    tmp[j] += tmp[j - coins[i]];
                }
            }
        }
        System.out.println(tmp[k]);
    }
}
