import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;
    static int[] parent;
    static boolean[] isSelected;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isSelected = new boolean[N + 1];
        arr = new int[M];
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i + 1;
        }
        sb = new StringBuilder();
        comb(0,0);
        System.out.println(sb.toString());
    }

    public static void comb(int cnt, int idx) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        if (idx == N) {
            return;
        }
        for (int i = idx; i < N; i++) {
            arr[cnt] = parent[i];
            comb(cnt+1, i);
        }
    }
}