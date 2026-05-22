import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[N][N];
        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][N];
        dp[0][N-1] = map[0][N-1];
        for(int i = 1; i < N; i++){
            dp[i][N-1] += dp[i-1][N-1] + map[i][N-1];
        }
        for(int i = N-2; i >= 0; i--){
            dp[0][i] += dp[0][i+1] + map[0][i];
        }
        for(int i = 1; i < N; i++){
            for(int j = N-2; j >= 0; j--){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j+1]) + map[i][j];
            }
        }
        System.out.println(dp[N-1][0]);
    }
}