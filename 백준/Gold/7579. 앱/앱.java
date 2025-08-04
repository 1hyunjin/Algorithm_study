import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memory = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        int[] cost = new int[N+1];
        int maxCost = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            maxCost += cost[i];
        }
        int[][] dp = new int[N+1][maxCost+1];
        Arrays.fill(dp[0], 0);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= maxCost; j++) {
                if (cost[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                if (cost[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]);
                    if (dp[i][j] >= M) {
                        result = Math.min(result, j);
                    }
                }
            }
        }
        System.out.println(result);
    }
}