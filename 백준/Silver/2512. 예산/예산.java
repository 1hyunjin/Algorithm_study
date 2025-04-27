import java.io.*;
import java.util.*;

public class Main {
    static int M, N, total;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        total = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
            max = Math.max(max, arr[i]);
        }

        M = Integer.parseInt(br.readLine());
        if (total <= M) {
            System.out.println(max);
            return;
        }

        int start = 1;
        int end = M;

        while (start < end) {
            int mid = (start + end + 1 )/2;
            if (isPossible(mid)) {
                start = mid;
            }
            else {
                end = mid -1;
            }
        }
        System.out.println(start);
    }

    public static boolean isPossible(int mid) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] < mid) {
                sum+=arr[i];
            }
            else {
                sum+=mid;
            }
        }
//        System.out.println("sum : " + sum);
        if (sum > M) {
            return false;
        }
        else {
            return true;
        }
    }
}