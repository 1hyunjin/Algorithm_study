import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[] L, R;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        L = new int[N];
        R = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            R[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(0,0));

    }

    public static int solve(int i, int j) {
        if (i == N || j == N) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int result = Math.max(solve(i + 1, j), solve(i + 1, j + 1));
        if (L[i] > R[j]) {
            result = Math.max(result, solve(i, j + 1) + R[j]);
        }
        return dp[i][j] = result;
    }
}