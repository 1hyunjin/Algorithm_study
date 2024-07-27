import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List[] adj = new List[N + 1];
        int[] deg = new int[N + 1];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            deg[b]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (deg[i] == 0) {
                queue.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for(int i = 0; i < adj[cur].size(); i++) {
                int next = (int) adj[cur].get(i);
                deg[next]--;
                if(deg[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        System.out.println(sb.toString());
    }
}