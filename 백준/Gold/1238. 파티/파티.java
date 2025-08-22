import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static List<Point>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[s].add(new Point(e, dist));
        }
        int[] arr = dikstra(X);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if(i==X) continue;
            int[] tmp  = dikstra(i);
            int sum = arr[i] + tmp[X];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    public static int[]  dikstra(int s) {
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return o1.dist - o2.dist;
            }
        });
        int[] arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[s] = 0;
        boolean[] visited = new boolean[N+1];
        pq.offer(new Point(s, 0));
        while(!pq.isEmpty()){
            Point cur = pq.poll();
            if(!visited[cur.v]){
                visited[cur.v] = true;
                for(Point next: graph[cur.v]){
                    if (arr[next.v] > arr[cur.v] + next.dist) {
                        arr[next.v] = arr[cur.v] + next.dist;
                        pq.offer(new Point(next.v, arr[next.v]));
                    }
                }
            }
        }
        return arr;
    }
    public static class Point{
        int v;
        int dist;

        public Point(int v, int dist) {
            this.v =v ;
            this.dist = dist;
        }
    }
}