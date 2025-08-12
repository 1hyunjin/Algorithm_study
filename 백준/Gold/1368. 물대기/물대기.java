import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });

        for (int i = 0; i < N; i++) {
            int cost = Integer.parseInt(br.readLine());
            pq.offer(new Node(i+1, N+1, cost));
        }

        parent = new int[N+2];
        for (int i = 0; i < N+2; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a != 0) {
                    pq.offer(new Node(i + 1, j + 1, a));
                }
            }
        }
        int result = 0;
        int picked = 0;
        while (!pq.isEmpty() && picked < N) {
            Node cur = pq.poll();
            if (find(cur.a) != find(cur.b)) {
                union(cur.a, cur.b);
                result+=cur.w;
                picked++;
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