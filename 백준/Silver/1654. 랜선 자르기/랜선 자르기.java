import java.util.*;
import java.io.*;

public class Main {
    static int K, N;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[(int) K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = Integer.MAX_VALUE;

        while (start < end) {
            long mid = (start + end + 1) / 2;
            if(solve(mid)){
                start = mid;
            }
            else {
                end = mid - 1;
            }

        }

        System.out.println(start);
    }

    public static boolean solve(long mid) {
        long cur = 0;
        for (int i = 0; i < K; i++) {
            cur += arr[i] / mid;
        }
        return cur >= N;
    }
}