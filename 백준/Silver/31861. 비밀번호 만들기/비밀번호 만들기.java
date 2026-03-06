import java.io.*;
import java.util.*;

class Main {
    static int MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[M+1][27];

        for (int i = 1; i <= 26; i++) {
            dp[1][i] = 1; // 길이가 1일때는 다 1개씩
        }

        for (int i = 2; i <= M; i++) {
            for (int j = 1; j <= 26; j++) { // 현재 알파벳
                for (int k = 1; k <= 26; k++) { // 이전 알파벳
                    if (Math.abs(j - k) >= N) { // 두 알파벳의 거리가 N 이상이라면
                        dp[i][j] = (dp[i][j] + dp[i-1][k]) % MOD;
                    }
                }
            }
        }
        long answer = 0;
        for (int i = 1; i <= 26; i++) {
            answer  = (answer + dp[M][i]) % MOD;
        }
        System.out.println(answer);
    }
}