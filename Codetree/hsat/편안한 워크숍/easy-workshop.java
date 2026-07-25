import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][N][K+1];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(dp[i][j], INF);
                dp[i][j][1] = 0; // 길이가 1이라 높이 차가 없음. 
            }
        }
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int len = 2; len <= K; len++){
            for(int x = 0; x < N; x++){
                for(int y = 0; y < N; y++){
                    for(int d = 0; d < 4; d++){
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                            continue;
                        }
                        // 반드시 높은 곳으로 이동해야 함.
                        if(map[nx][ny] <= map[x][y]){
                            continue;
                        }
                        // 다음 칸에서 len-1짜리 경로 만들 수 없으면 continue
                        if(dp[nx][ny][len-1] == INF){
                            continue;
                        }
                        int diff = map[nx][ny] - map[x][y];

                        int candidate = Math.max(diff, dp[nx][ny][len-1]);

                        dp[x][y][len] = Math.min(dp[x][y][len], candidate);
                    }
                }
            }
        }
        int answer = INF;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                answer = Math.min(answer, dp[i][j][K]);
            }
        }
        if(answer == INF){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }
}