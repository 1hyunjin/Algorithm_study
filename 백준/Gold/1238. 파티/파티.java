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
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Point(v, w));
        }
        int[] back = func(X); // 돌아오는거
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if(i == X) continue;

            int[] go = func(i);
            int total = go[X] + back[i];
            max = Math.max(max, total);
        }

        System.out.println(max);
    }

    public static int[] func(int start) {
        int[] arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N+1];

        PriorityQueue<Point> backPq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return o1.dist - o2.dist;
            }
        });

        backPq.add(new Point(start, 0));
        arr[start] = 0;

        while (!backPq.isEmpty()) {
            Point cur = backPq.poll();
            if (!visited[cur.v]) {
                visited[cur.v] =true;
                for (Point next : graph[cur.v]) {
                    if (arr[next.v] > arr[cur.v] + next.dist) {
                        arr[next.v] = arr[cur.v] + next.dist;
                        backPq.add(new Point(next.v, arr[next.v]));
                    }
                }
            }
        }
        return arr;
    }
    public static class Point{
        int v ;
        int dist;

        public Point(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
}