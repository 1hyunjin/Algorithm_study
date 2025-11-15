import java.util.*;
import java.io.*;

public class Main {
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] map = new int[V + 1][V + 1];
        for (int i = 0; i <= V; i++) {
            Arrays.fill(map[i], INF);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = cost;

        }
        for (int i = 0; i <= V; i++) {
            map[i][i] = 0;
        }
        for (int k = 1; k <= V; k++) { // 중간 다리
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if(i == j) continue;
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        int answer = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(i == j) continue;
                if(map[i][j] != INF && map[j][i] != INF){
                    answer = Math.min(answer, map[i][j] + map[j][i]);
                }
            }
        }
        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}