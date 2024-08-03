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

        ArrayList<Node>[] graph = new ArrayList[V+1];

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, weight));
        }

        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF); // 거리를 무한으로 초기 설정

        dist[start] = 0;  // 첫 정점을 0으로 설정 (자기 자신과의 거리는 0)

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            visited[cur.v] = true; // 정점 방문

            for (Node next : graph[cur.v]) {
                if (!visited[next.v] && dist[next.v] > dist[cur.v] + next.weight) {
                    dist[next.v] = dist[cur.v] + next.weight;  // 작은 값으로 값 갱신
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }


    }
    public static class Node{
        int v;
        int weight;

        public Node(int v, int cost) {
            this.v = v;
            this.weight = cost;
        }
    }
}