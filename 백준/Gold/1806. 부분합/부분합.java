import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        while (right < N + 1) {
            long diff = arr[right]-arr[left];
            if (diff < S) {
                right++;
            }
            else {
                len = Math.min(len, right-left);
                left++;
            }
        }
        System.out.println(len==Integer.MAX_VALUE?0:len);
    }
}