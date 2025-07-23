import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        List<Point>[] graph = new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[u].add(new Point(v, dist));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

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
                System.out.println(arr[end]);
                break;
            }
            for(Point next: graph[cur.v]){
                if (cur.dist + next.dist < arr[next.v]) {
                    arr[next.v] = cur.dist+next.dist;
                    pq.offer(new Point(next.v, arr[next.v]));
                }
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