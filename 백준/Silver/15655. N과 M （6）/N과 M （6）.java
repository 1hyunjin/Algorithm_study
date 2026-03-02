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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(parent);
        sb = new StringBuilder();
        comb(0, 0);
        System.out.println(sb.toString());
    }

    public static void comb(int cnt, int idx) {
        if (cnt == M) {
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    sb.append(parent[i]).append(" ");
                }
            }
            sb.append('\n');
            return;
        }
        if(idx == N){
            return;
        }
        isSelected[idx] = true;
        comb(cnt + 1, idx + 1);
        isSelected[idx] = false;
        comb(cnt, idx + 1);
    }
}