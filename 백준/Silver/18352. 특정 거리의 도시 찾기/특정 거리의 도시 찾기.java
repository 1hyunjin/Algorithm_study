import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Point>[] graph = new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(new Point(v, 1));
        }
        int[] arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[X] = 0;

        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return o1.dist - o2.dist;
            }
        });

        pq.offer(new Point(X, 0));
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if(cur.dist == K){
                result.add(cur.v);
            }
            for (Point next : graph[cur.v]) {
                if (arr[next.v] > arr[cur.v] + next.dist) {
                    arr[next.v] = arr[cur.v] + next.dist;
                    pq.offer(new Point(next.v, arr[next.v]));
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        }
        else{
            Collections.sort(result);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
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