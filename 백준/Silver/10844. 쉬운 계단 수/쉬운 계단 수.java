import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int INF = 1000000000;
        int[][] dp = new int[101][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i-1][1]%INF;
                }
                else if (j == 9) {
                    dp[i][9] = dp[i-1][8]%INF;
                }
                else{
                    dp[i][j] = (dp[i-1][j-1]+ dp[i-1][j+1])%INF;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum+dp[N][i])%INF;
        }
        System.out.println(sum);
    }
}