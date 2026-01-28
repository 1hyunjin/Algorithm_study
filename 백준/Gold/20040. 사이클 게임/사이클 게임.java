import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(a) != find(b)) {
                union(a, b);
            }
            else{
                answer = i+1;
                break;
            }
        }
        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        parent[rootA] = rootB;
    }
    public static int find(int x) {
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

}