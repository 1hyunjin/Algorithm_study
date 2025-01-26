import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[] dp = new int[11];

        Arrays.fill(dp, 0);

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        while (tc > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
            tc--;
        }
        System.out.println(sb);
    }
}