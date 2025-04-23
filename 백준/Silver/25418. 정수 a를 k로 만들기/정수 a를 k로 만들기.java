import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[A] = 0;


        for (int i = A + 1; i <= K; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            if (i % 2 == 0 && i / 2 >= A) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[K]);
    }
}
