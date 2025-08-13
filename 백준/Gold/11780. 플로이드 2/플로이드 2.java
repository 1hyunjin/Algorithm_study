import java.util.*;
import java.io.*;
import java.util.function.DoubleToIntFunction;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int n = Integer.parseInt(br.readLine()); // 플로이드 시간복잡도 O(n^3);
        int m = Integer.parseInt(br.readLine());
        long[][] map = new long[n+1][n+1];
        int[][] next = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], INF);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (map[start][end] > cost) {
                map[start][end] = cost;
                next[start][end] = end;
            }
        }
        // 자기자신은 0으로
        for (int i = 1; i <= n; i++) {
            map[i][i] = 0;
        }
        // k : 중간에 거치는 도시
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == INF) {
                    sb.append(0).append(" ");
                }
                else{
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j || map[i][j] == INF){
                    sb.append(0).append("\n");
                    continue;
                }
                List<Integer> list =new ArrayList<>();
                int cur = i;
                list.add(cur);
                while (cur != j) {
                    list.add(next[cur][j]);
                    cur = next[cur][j];
                }
                sb.append(list.size()).append(" ");
                for (int k = 0; k < list.size(); k++) {
                    if (k > 0) {
                        sb.append(" ");
                    }
                    sb.append(list.get(k));
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}