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
            adj[i] = new LinkedList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] tmp = new int[num];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < tmp.length - 1; j++) {
                int start = tmp[j];
                int end = tmp[j + 1];
                adj[start].add(end);
                deg[end]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(deg[i] == 0) {
                queue.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur= queue.poll();
            sb.append(cur).append("\n");
            for (int i = 0; i < adj[cur].size(); i++) {
                int next = (int) adj[cur].get(i);
                deg[next]--;
                if(deg[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        boolean isCycle = false;
        for (int i = 0; i < deg.length; i++) {
            if (deg[i] != 0) {
                isCycle = true;
                break;
            }
        }
        if (isCycle) {
            System.out.println("0");
        } else {
            System.out.println(sb.toString());
        }
    }

}