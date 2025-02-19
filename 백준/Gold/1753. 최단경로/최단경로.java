import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Point>[]  list = new List[V+1];

        for (int i = 0; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }
        int INF = Integer.MAX_VALUE;

        int[] arr = new int[V+1];
        boolean[] visited = new boolean[V+1];
        Arrays.fill(arr, INF);

        int start = Integer.parseInt(br.readLine());
        arr[start] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            list[u].add(new Point(v, dist));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2) {
                return p1.dist - p2.dist;
            }
        });

        pq.add(new Point(start, 0));

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            visited[cur.v] = true;

            for (int i = 0; i < list[cur.v].size(); i++) {
                int nextV = list[cur.v].get(i).v;
                int nextDist = list[cur.v].get(i).dist;

                if (!visited[nextV] && arr[nextV] > arr[cur.v] + nextDist) {
                    arr[nextV] = arr[cur.v] + nextDist; // 최단 경로로 갱신
                    pq.add(new Point(nextV, arr[nextV]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (arr[i] == INF) {
                System.out.println("INF");
            }
            else {
                System.out.println(arr[i]);
            }
        }
    }

    public static class Point{
        int v;
        int dist;

        public Point(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
}