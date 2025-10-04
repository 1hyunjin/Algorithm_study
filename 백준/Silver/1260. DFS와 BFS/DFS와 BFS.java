import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static boolean[] visited;
    static List<Integer>[] graph;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for(List list : graph){
            Collections.sort(list);
        }
        sb = new StringBuilder();
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs();
        System.out.println(sb);
    }
    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");
        for (int v : graph[start]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
    public static void bfs() {
        visited[V] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(V);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for(int next : graph[cur]){
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}