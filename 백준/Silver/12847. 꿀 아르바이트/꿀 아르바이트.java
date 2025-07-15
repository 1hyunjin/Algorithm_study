import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        long sum = arr[M]-arr[0]; // 초기 윈도우
        long max = sum;
        int end = M+1;

        while (end <= N) {
            sum = arr[end] - arr[end - M];
            max = Math.max(max, sum);
            end++;
        }

        System.out.println(max);
    }
}