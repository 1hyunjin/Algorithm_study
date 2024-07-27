import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Edge>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Edge(end, cost));
            list[end].add(new Edge(start, cost));
        }
        visited = new boolean[N + 1];
        System.out.println(prim());
    }
    public static int prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        int dist = 0;
        int max = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (!visited[cur.to]) {
                visited[cur.to] = true;
            } else {
                continue;
            }
            max = Math.max(max, cur.cost);
            dist += cur.cost;

            for (int i = 0; i < list[cur.to].size(); i++) {
                Edge  next = list[cur.to].get(i);
                if (!visited[next.to]) {
                    pq.offer(new Edge(next.to, next.cost));
                }
            }
        }
        return dist - max;
    }

    public static class Edge implements Comparable<Edge>{
        int  to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}