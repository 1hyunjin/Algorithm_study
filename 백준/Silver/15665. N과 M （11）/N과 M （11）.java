import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;
    static int[] parent;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        parent = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(parent);
        sb = new StringBuilder();
        comb(0);
        System.out.println(sb.toString());
    }

    public static void comb(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        int prev = 0;
        for (int i = 0; i < N; i++) {
            if (prev != parent[i]) {
                prev = parent[i];
                arr[cnt] = parent[i];
                comb(cnt + 1);
            }
        }
    }
}