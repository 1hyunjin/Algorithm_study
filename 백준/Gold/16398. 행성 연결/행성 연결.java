import java.util.*;
import java.io.*;

public class Main {
    static int V, E;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w - o2.w;
            }
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (i != j) {
                    pq.offer(new Node(i, j, val));
                }
            }
        }
        long cost = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.u) != find(cur.v)) {
                union(cur.u, cur.v);
                cost += cur.w;
            }
        }
        System.out.println(cost);
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