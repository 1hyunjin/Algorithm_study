import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[N][2];

        dp[0][0] = arr[0];
        dp[0][1] = 0;
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(Math.min(dp[N-1][0], dp[N-1][1]));
    }
}