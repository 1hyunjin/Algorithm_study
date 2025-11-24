import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[][] dp = new long[1001][1001];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[3][1] = 1;
        dp[2][2] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;
        for (int i = 4; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                dp[i][j] = (dp[i - 3][j - 1] + dp[i - 2][j - 1] + dp[i - 1][j - 1])%1000000009;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(dp[n][m]).append("\n");
        }
        System.out.println(sb.toString());
    }
}