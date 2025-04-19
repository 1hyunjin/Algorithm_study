import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][T+1];

        Chapter[] arr = new Chapter[N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Chapter(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.fill(dp[0], 0);

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= T; j++){
                if (j - arr[i].k < 0) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i].k] + arr[i].s);
                }
            }
        }
        System.out.println(dp[N][T]);
    }
    public static class Chapter{
        int k;
        int s;

        public Chapter(int k, int s) {
            this.k = k;
            this.s = s;
        }
    }
}
