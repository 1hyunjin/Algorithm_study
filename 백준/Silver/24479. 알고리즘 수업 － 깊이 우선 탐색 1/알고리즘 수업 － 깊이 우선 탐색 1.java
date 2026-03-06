import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] graph;
    static int[] order;
    static int N,M, idx;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        order = new int[N+1];
        visited = new boolean[N+1];
        idx = 1;
        dfs(R);
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    public static void dfs(int start) {
        visited[start] = true;
        order[start] = idx++;
        for (int v : graph[start]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
}