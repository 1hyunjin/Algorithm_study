import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] graph;
    static int N, M, R;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        visited = new boolean[N+1];

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
            Collections.sort(graph[i], Collections.reverseOrder());
        }
        dfs(R, 0);
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                System.out.println(-1);
            }
            else{
                System.out.println(arr[i]);
            }
        }
    }

    public static void dfs(int start, int num) {
        visited[start] = true;
        arr[start] = num;
        for (int v : graph[start]) {
            if (!visited[v]) {
                dfs(v, num+1);
            }
        }
    }
}