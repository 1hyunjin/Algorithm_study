import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int dist = 1 + (2 * K);
        int end = Math.min(1000000, dist);
        int[] arr = new int[1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[x] = w;
        }

        long sum = 0;
        long max = 0;

        for (int i = 0; i < end; i++) {
            sum += arr[i];
        }
        max = Math.max(max, sum);

        for (int i = dist; i <= 1000000; i++) {
            sum += arr[i];
            sum -= arr[i-dist];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}