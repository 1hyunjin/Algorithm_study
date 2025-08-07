import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long start = 0;
        long end = arr[N-1];
        long maxHeight = arr[N-1];
        while (start <= end) {
            long mid = (start+end+1)/2;
            if (isGet(mid)) {
                start = mid+1;
                maxHeight = mid;
            }
            else{
                end = mid -1;
            }
        }
        System.out.println(maxHeight);
    }

    public static boolean isGet(long mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] >= mid) {
                sum+= arr[i] - mid;
            }
        }
        return sum >= M;
    }
}