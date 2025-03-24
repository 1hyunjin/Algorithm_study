import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static Edge[] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new Edge[M];

        arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[i] = new Edge(from, to, weight);
        }
        Arrays.sort(graph);
        int result = 0;
        int cnt = 0;

        for (Edge edge : graph) {
            if (union(edge.from, edge.to)) {
                continue;
            }
            result += edge.weight;
            if (++cnt == N - 1) {
                break;
            }
        }
        System.out.println(result);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return true;
        if (aRoot < bRoot) {
            arr[bRoot] = aRoot;
        }
        if (aRoot > bRoot) {
            arr[aRoot] = bRoot;
        }
        return false;
    }

    public static int find(int x) {
        if(arr[x] == x)return x;
        return arr[x] = find(arr[x]);
    }

    public static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
}
