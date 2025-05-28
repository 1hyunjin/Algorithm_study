import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];

        dp[0] = 1;

        for(int i = 1; i <= N; i++){
            long sum = 0;
            for(int j = 0; j < i; j++){
                sum+= dp[j]*dp[i-1-j];
            }
            dp[i] = sum;
        }
        System.out.println(dp[N]);
    }
}