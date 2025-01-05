import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int [N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[N-1];

        int result = 0;

        while (start <= end) {
            int mid = (start + end)/2;

            if (solved(mid)) {
                result = Math.max(mid, result);
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }

    public static boolean solved(long mid) {
        long cur = 0;
        for (int i = 0; i < N; i++) {
            cur += arr[i]/mid;
        }
        return cur >= M;
    }
}