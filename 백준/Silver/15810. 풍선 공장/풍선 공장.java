import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long start = 1;
        long end =(long)arr[N - 1] *M;
        long min = Long.MAX_VALUE;
        while (start <= end) {
            long mid = (start+end)/2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += mid/arr[i];
            }
            if (sum >= M) {
                end = mid-1;
                min = Math.min(min, mid);
            }
            else {
                start = mid+1;
            }
        }
        System.out.println(min);
    }
}