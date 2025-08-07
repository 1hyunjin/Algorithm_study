import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map =new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            dp[i][0] = map[i][0];
        }
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < M; i++) {
                for (int k = 0; k < M; k++) {
                    if(i == k){
                        dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + map[i][j]/2);
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j], dp[k][j-1] + map[i][j]);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < M; i++) {
            max = Math.max(max, dp[i][N-1]);
        }
        System.out.println(max);
    }
}