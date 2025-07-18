import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Point>[] graph = new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE); // 무한으로
        int[] prev = new int[N+1];
        for (int i = 0; i < M; i++) {
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
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        arr[start] = 0;

        pq.offer(new Point(start, 0));
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.v == end) {
                break;
            }
            for (Point next : graph[cur.v]) {
                if (arr[next.v] > arr[cur.v] + next.w) {
                    arr[next.v] = arr[cur.v] + next.w;
                    pq.add(new Point(next.v, arr[next.v]));
                    prev[next.v] = cur.v;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr[end]).append("\n");
        int cur = end;
        Stack<Integer> stack = new Stack<>();
        while (cur != start) {
            stack.push(cur);
            cur = prev[cur];
        }
        stack.push(start);
        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
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