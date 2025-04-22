import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];
        for (int i = 0; i < 15; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j <15; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[k][n]);
        }
    }
}
