import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < K; i++) {
            total += arr[i];
        }
        max = Math.max(max, total);
        int s = 0;
        int e = K-1;

        while (true) {
            e++;
            if (e >= N) {
                break;
            }
            total += arr[e];
            total -= arr[s];
            s++;
            max = Math.max(max, total);
        }
        System.out.println(max);
    }
}