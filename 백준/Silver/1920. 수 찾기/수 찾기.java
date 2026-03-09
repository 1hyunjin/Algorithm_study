import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] brr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = brr[i];
            int start = 0;
            int end = N-1;
            boolean isMatch = false;
            while (start <= end) {
                int mid = (start+end)/2;
                if (arr[mid] == target) {
                    isMatch = true;
                    break;
                }
                if (target < arr[mid]) {
                    end = mid-1;
                }
                if (target > arr[mid]) {
                    start = mid+1;
                }
            }
            if (isMatch) {
                sb.append(1).append('\n');
            }
            else{
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}