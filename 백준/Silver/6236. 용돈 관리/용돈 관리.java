import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int start = 0;
        int end = 100000 * 10000;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, arr[i]);
            end += arr[i];
        }

        int result = 0;
        while(start <= end){
            int mid = (start + end)/2;
            int money = mid;
            int cnt = 1;
            for (int i = 0; i < N; i++) {
                if (money < arr[i]) {
                    money = mid; // 인출
                    cnt++;
                }
                money -=  arr[i];
            }

            if (cnt <= M) {
                result = mid;
                end = mid -1;
            }
            else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}