import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[C];
        long total = 0;
        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }
        Arrays.sort(arr);

        long start = 1;
        long end = arr[C-1];
        long left = 0;
        long max = 0;
        while (start <= end) {
            long mid = (start+end)/2;
            long sum = 0;
            left = 0;
            for (int i = 0; i < C; i++) {
                sum += arr[i]/mid;
            }
            if (sum >= C) {
                start =  mid+1;
                max = mid;
            }
            else {
                end = mid-1;
            }
        }
        for (int i = 0; i < C; i++) {
            left = total - (max * C);
        }
        System.out.println(left);
    }
}