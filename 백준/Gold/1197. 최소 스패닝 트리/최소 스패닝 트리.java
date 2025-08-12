import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w - o2.w;
            }
        });
        parent = new int[V+1];
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a, b, w));
        }
        int result = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.a) != find(cur.b)) {
                union(cur.a, cur.b);
                result+=cur.w;
            }
        }
        System.out.println(result);
    }
    public static class Node{
        int a;
        int b;
        int w;

        public Node(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
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
    public static int find(int x){
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}