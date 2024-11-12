import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            visited[cur.v] = true;

            for (Node next : graph[cur.v]) {
                if (!visited[next.v] && dist[next.v] > dist[cur.v] + next.weight) {
                    dist[next.v] = dist[cur.v] + next.weight;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }

    public static class Node{
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }
}