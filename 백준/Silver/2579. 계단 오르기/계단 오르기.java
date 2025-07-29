import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[][] dp = new int[301][3];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        if (N == 1) {
            System.out.println(stairs[1]);
            return;
        }

        dp[1][1] = stairs[1];
        dp[1][2] = 0;
        dp[2][1] = stairs[2];
        dp[2][2] = stairs[1] + stairs[2];

        for (int k = 3; k <= N; k++) {
            dp[k][1] = Math.max(dp[k - 2][1], dp[k - 2][2]) + stairs[k];
            dp[k][2] = dp[k - 1][1] + stairs[k];
        }
        System.out.println(Math.max(dp[N][1], dp[N][2]));
    }
}