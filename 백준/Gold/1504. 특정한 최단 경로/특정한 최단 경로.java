import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static int INF = 200000000;
    static List<Point>[] graph;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        arr = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Point(b, c));
            graph[b].add(new Point(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int route1 = dikstra(1, v1) + dikstra(v1, v2) + dikstra(v2, N);
        int route2 = dikstra(1, v2) + dikstra(v2, v1) + dikstra(v1, N);

        if (route1 >= INF && route2 >= INF) {
            System.out.println(-1);
        }
        else{
            System.out.println(Math.min(route1, route2));
        }
    }

    public static int dikstra(int start, int end) {
        Arrays.fill(arr, INF);
        arr[start] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return o1.dist - o2.dist;
            }
        });
        pq.offer(new Point(start, 0));

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.v == end) {
                return cur.dist;
            }
            for (Point next : graph[cur.v]) {
                if (arr[next.v] > arr[cur.v] + next.dist) {
                    arr[next.v] = arr[cur.v] + next.dist;
                    pq.offer(new Point(next.v, arr[next.v]));
                }
            }
        }
        return INF;
    }

    public static class Point {
        int v;
        int dist;

        public Point(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
}