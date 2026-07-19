import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long left = 1;
        long right = arr[N-1]- arr[0] + 1;
        long min = right;
        while(left <= right){
            long mid = (left + right)/2;

            if(isMatch(mid)){
                min = Math.min(min, mid);
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        System.out.println(min);
    }
    public static boolean isMatch(long mid){
        int cnt = 1;
        int s = arr[0];
        long end = arr[0] + mid -1;
        for(int i = 1; i < N; i++){
            if(arr[i] > end){
                cnt++;
                end = arr[i]+mid-1;
            }
        }
        if(cnt <= K){
            return true;
        }
        return false;
    }
}