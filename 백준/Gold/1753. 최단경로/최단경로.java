import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Point>[] graph = new List[V+1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] arr = new int[V+1];
        Arrays.fill(arr, Integer.MAX_VALUE); // 무한으로
        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Point(v, w));
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return o1.w - o2.w;
            }
        });
        arr[start] = 0;
        pq.offer(new Point(start, 0));
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            for (Point next : graph[cur.v]) {
                if (arr[next.v] > arr[cur.v] + next.w) {
                    arr[next.v] = arr[cur.v] + next.w;
                    pq.add(new Point(next.v, arr[next.v]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (arr[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            }
            else{
                sb.append(arr[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static class Point{
        int v;
        int w;

        public Point(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}