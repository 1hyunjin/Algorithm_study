import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int total = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            total += arr[i];
        }
        int start = max;
        int end = total;
        int result = 0;
        while (start <= end) {
            int mid = (start+end+1)/2;
            if (isPossible(mid)) {
                end = mid-1;
                result = mid;
            }
            else{
                start = mid+1;
            }
        }
        System.out.println(result);
    }
    public static boolean isPossible(int mid){
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (sum+arr[i] > mid) {
                cnt++;
                sum=0;
            }
            sum+=arr[i];
        }
        return cnt <= M;
    }
}