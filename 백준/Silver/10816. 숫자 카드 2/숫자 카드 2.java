import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(upperBound(num) - lowerBound(num)).append(" ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(int target) {
        int lo = 0;
        int hi = N;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (target <= arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static int upperBound(int target) {
        int lo = 0;
        int hi = N;

        while (lo < hi) {
            int mid = (lo + hi) /2;

            if (target < arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}