import java.util.*;
import java.io.*;

public class Main {
    static int V, E;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if (M == 0 && N == 0) {
                break;
            }
            parent = new int[M+1];
            for (int i = 0; i <= M; i++) {
                parent[i] = i;
            }
            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.w - o2.w;
                }
            });
            long total = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                pq.offer(new Node(u, v, w));
                total += w;
            }

            long result = 0;
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (find(cur.u) != find(cur.v)) {
                    result+=cur.w;
                    union(cur.u, cur.v);
                }
            }
            System.out.println(total - result);
        }
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA < rootB) {
            parent[rootB] = rootA;
        }
        else{
            parent[rootA] = rootB;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static class Node{
        int u;
        int v;
        int w;

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}