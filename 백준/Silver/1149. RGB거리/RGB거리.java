import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            if(i == 1){
                dp[1][0] = red;
                dp[1][1] = green;
                dp[1][2] = blue;
            }
            else {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + red;
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + green;
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + blue;
            }

        }
        int result = dp[N][0];
        result = Math.min(result, dp[N][1]);
        result = Math.min(result, dp[N][2]);

        System.out.println(result);
    }
}