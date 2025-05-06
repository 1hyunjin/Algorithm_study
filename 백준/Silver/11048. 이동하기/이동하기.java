import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = map[0][0];
        int[] dx = {1, 0, 1};
        int[] dy = {0, 1, 1};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx >= N || ny >= M) {
                        continue;
                    }
                    int next = dp[i][j] + map[nx][ny];
                    if(next > dp[nx][ny]){
                        dp[nx][ny] = next;
                    }
                }
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}