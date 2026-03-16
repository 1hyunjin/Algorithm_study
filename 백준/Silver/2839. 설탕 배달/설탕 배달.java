import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp, 5000);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            if (i >= 3) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
            if (i >= 5) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }
        if (dp[N] == 5000) {
            System.out.println(-1);
        }
        else{
            System.out.println(dp[N]);
        }
    }
}