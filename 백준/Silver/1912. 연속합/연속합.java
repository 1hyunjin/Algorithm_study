import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = arr[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < dp[i - 1] + arr[i]) {
                dp[i] = dp[i - 1] + arr[i];
            }
            else {
                dp[i] = arr[i];
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}