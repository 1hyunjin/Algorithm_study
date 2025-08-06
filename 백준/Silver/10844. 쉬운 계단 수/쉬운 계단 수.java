import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 1000000000;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                }
                else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                }
                else{
                    dp[i][j] = (dp[i-1][j-1]%mod + dp[i-1][j+1]%mod)%mod;
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum+=dp[N][i];
            sum%=mod;
        }
        System.out.println(sum%mod);
    }
}