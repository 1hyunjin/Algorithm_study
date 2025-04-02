import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static int[] op;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        op = new int[4];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        int sum = arr[0];
        backTracking(1, sum);
        System.out.println(max);
        System.out.println(min);
    }
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void backTracking(int idx, int sum) {
        if (idx == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                switch(i){
                    case 0: backTracking(idx+1, sum+arr[idx]); break;
                    case 1: backTracking(idx+1, sum-arr[idx]); break;
                    case 2: backTracking(idx+1, sum*arr[idx]); break;
                    case 3: backTracking(idx+1, sum/arr[idx]); break;
                }
                op[i]++;
            }
        }
    }
}
