import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            if (i >= 1) {
                dp[i] = Math.min(dp[i], dp[i-1] + 1);
            }
            if (i >= 2) {
                dp[i] = Math.min(dp[i], dp[i-2] + 1);
            }
            if (i >= 5) {
                dp[i] = Math.min(dp[i], dp[i-5] + 1);
            }
            if (i >= 7) {
                dp[i] = Math.min(dp[i], dp[i-7] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}