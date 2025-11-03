import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        if (N % 2 != 0) {
            long last = arr[N-1];
            for (int i = 0; i < N / 2; i++) {
                long sum = arr[i] + arr[N - i - 2];
                last = Math.max(last, sum);
            }
            System.out.println(last);
        }
        else{
            long last = 0;
            for (int i = 0; i < N / 2; i++) {
                long sum = arr[i] + arr[N - i - 1];
                last = Math.max(last, sum);
            }
            System.out.println(last);
        }
    }
}