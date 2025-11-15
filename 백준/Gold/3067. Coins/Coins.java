import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[][] dp = new int[N+1][M+1];
            dp[0][0] = 1;
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= M; j++) {
                    if (j < coins[i]) {
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] += dp[i - 1][j] + dp[i][j - coins[i]];
                    }
                }
            }
            sb.append(dp[N][M]).append("\n");
        }
        System.out.println(sb.toString());
    }
}