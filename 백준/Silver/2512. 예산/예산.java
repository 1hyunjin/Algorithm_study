import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        if (sum <= M) {
            System.out.println(arr[N - 1]);
        }
        else {
            int start = 1;
            int end = arr[N-1];

            while (start < end-1) {
                int mid = (start + end) / 2;

                if (solved(mid) > M) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            System.out.println(start);
        }
    }

    public static int solved(int mid) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += Math.min(arr[i], mid);
        }
        return total;
    }
}