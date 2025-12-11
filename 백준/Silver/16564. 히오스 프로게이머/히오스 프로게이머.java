import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i =0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long l = arr[0];
        long r = arr[0]+K;
        long result = 0;
        while (l <= r) {
            long mid = (l+r)/2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] < mid) {
                    sum += (mid-arr[i]);
                }
            }
            if (sum <= K) {
                result = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        System.out.println(result);
    }
}