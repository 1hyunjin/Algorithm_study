import java.util.*;
import java.io.*;

public class Main {
    static int V, E;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w - o2.w;
            }
        });
        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new Node(A, B, C));
        }
        int result  = 0;
        int lastBridge = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.u) != find(cur.v)) {
                union(cur.u, cur.v);
                result+= cur.w;
                lastBridge = cur.w;
            }
        }
        System.out.println(result - lastBridge);
    }
    public static void union(int a, int b){
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
        return parent[x] = find(parent[x]); // 경로 압축
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