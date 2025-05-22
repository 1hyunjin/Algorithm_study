import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new List[N+1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        int related = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        int cnt = 0;
        out:while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Integer cur = queue.poll();
                if (related > 2) {
                    break out;
                }
                cnt++;
                for (int v : graph[cur]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
            related++;
        }
        System.out.println(cnt-1);
    }
}