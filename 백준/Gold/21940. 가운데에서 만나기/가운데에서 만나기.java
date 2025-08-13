import java.util.*;
import java.io.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] map = new long[N+1][N+1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(map[i], INF);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (map[a][b] > cost) {
                map[a][b] = cost;
            }
        }
        for (int i = 1; i <= N; i++) {
            map[i][i] = 0;
        }
        int K = Integer.parseInt(br.readLine());
        int[] friends = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }
        for(int k = 1; k <= N; k++){
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(i == j) continue;
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        long best = Integer.MAX_VALUE;
        List<Integer> list =new ArrayList<>();
        for (int c = 1; c <= N; c++) {  // 도시 X
            long worst = 0;
            boolean isOk = true;
            for (int i = 0; i < K; i++) {
                int f = friends[i];
                if(map[f][c] == INF || map[c][f] == INF){
                    isOk = false;
                    break;
                }
                long dist = map[f][c] + map[c][f];
                if(dist > worst) worst = dist;
            }
            if(!isOk) continue;
            if (worst < best) {
                best = worst;
                list.clear();
                list.add(c);
            } else if (worst == best) {
                list.add(c);
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}