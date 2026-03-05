import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] arr;
    static int[] D;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        D = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < K; i++) {
            shupple();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void shupple() {
        int[] tmp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            int idx = D[i];
            int val = arr[i];
            tmp[idx] = val;
        }
        for (int i = 1; i <= N; i++) {
            arr[i] = tmp[i];
        }
    }
}