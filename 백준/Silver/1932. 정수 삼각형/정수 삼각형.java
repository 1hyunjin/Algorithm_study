import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cnt; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = arr[i][j];
                if (i > 0 && j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                } else if (i > 0 && j == cnt - 1) {
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                }
                else if(i > 0){
                    dp[i][j] = Math.max(dp[i - 1][j] + arr[i][j], dp[i - 1][j - 1] + arr[i][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
            cnt++;
        }
        System.out.println(max);

    }
}