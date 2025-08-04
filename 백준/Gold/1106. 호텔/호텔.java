import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] costs = new int[N + 1];
        int[] people = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N + 1][100001];
        Arrays.fill(dp[0], 0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < 100001; j++) {
                if (j >= costs[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - costs[i]] + people[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][j] >= C) {
                    min = Math.min(min, j);
                }
            }
        }
        System.out.println(min);
    }
}