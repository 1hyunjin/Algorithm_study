import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int N, L, R, X, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        result = 0;
        func(0);
        System.out.println(result);
    }

    public static void func(int idx) {
        if (idx == N) {
            int cnt = 0;
            long sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    cnt++;
                    sum += arr[i];
                    min = Math.min(min, arr[i]);
                    max = Math.max(max, arr[i]);
                }
            }
            if (cnt >= 2) {
                if (sum >= L && sum <= R && max - min >= X) {
                    result++;
                }
            }
            return;
        }
        visited[idx] = true;
        func(idx + 1);
        visited[idx] = false;
        func(idx + 1);
    }
}