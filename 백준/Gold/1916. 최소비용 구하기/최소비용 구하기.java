import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        List<Point>[] graph = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] arr = new int[V + 1];

        Arrays.fill(arr, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Point(w, v));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return o1.dist - o2.dist;
            }
        });
        boolean[] visited = new boolean[V+1];

        pq.add(new Point(0, start));
        arr[start] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (!visited[cur.v]) {
                visited[cur.v] = true;
                for (Point p : graph[cur.v]) {
                    if (arr[p.v] > arr[cur.v] + p.dist) {
                        arr[p.v] = arr[cur.v] + p.dist;
                        pq.add(new Point(arr[p.v], p.v));
                    }
                }
            }
        }
        System.out.println(arr[end]);
    }

    public static class Point {
        int dist;
        int v;

        public Point(int dist, int v) {
            this.dist = dist;
            this.v = v;
        }
    }
}