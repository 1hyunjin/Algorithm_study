import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= arr[0]; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                break;
            }
            for (int j = i + 1; j <= i + arr[i]; j++) {
                if(j >= N) continue;
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        if (dp[N - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else{
            System.out.println(dp[N-1]);
        }
    }
}