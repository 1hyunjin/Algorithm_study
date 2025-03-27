import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int cost = Integer.parseInt(br.readLine());

            int[] dp = new int[cost+1];
            dp[0] = 1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= cost; j++) {
                    if (j - coins[i] >= 0) {
                        dp[j] += dp[j - coins[i]];
                    }
                }
            }
            System.out.println(dp[cost]);
        }
    }
}