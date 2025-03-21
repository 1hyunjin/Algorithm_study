import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[3][N+1];
        dp[0][1] = 0;
        dp[1][1] = 1;
        dp[2][1] = 1;
        int mod = 1000000009;
        for(int j = 2; j <= N; j++){
             for(int i = 0; i < 3; i++){
                 dp[i][j] = (dp[0][j-1] + dp[1][j-1] + dp[2][j-1])%mod;
             }
        }
        System.out.println(dp[0][N]);
    }
}