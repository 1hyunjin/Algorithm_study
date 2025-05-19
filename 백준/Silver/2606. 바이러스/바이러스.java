import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer>[] graph = new List[N+1];
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
        boolean[] visited = new boolean[N+1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            for (int v : graph[cur]) {
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}