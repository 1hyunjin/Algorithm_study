import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long start = 0;
        long end = arr[N - 1];
        long result = 0;
        while (start <= end) {
            long mid = (start+end+1)/2;
            if (isCut(mid)) {
                start = mid+1;
                result = mid;
            }
            else{
                end = mid-1;
            }
        }
        System.out.println(result);
    }

    public static boolean isCut(long mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] >= mid) {
                sum += arr[i]-mid;
            }
        }
        if (sum >= M) {
            return true;
        }
        return false;
    }
}