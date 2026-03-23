import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            long[][] dp = new long[N+1][10];
            Arrays.fill(dp[1], 1);

            for (int i = 2; i <= N; i++) {
                for (int j = 0; j <= 9; j++) {
                    if(j == 0){
                        dp[i][0] = 1;
                    }
                    else{
                        dp[i][j] = dp[i][j-1] + dp[i-1][j];
                    }
                }
            }
            long sum = 0;
            for (int i = 0; i <= 9; i++) {
                sum += dp[N][i];
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb.toString());
    }
}