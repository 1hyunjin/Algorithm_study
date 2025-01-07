import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long total = 0;

        int left = 0;
        int right = 0;

        int cnt = 0;

        while (right <= N) {
            if (total >= M) {
                total -= arr[left];
                left++;
            }
            else if (total < M) {
                total += arr[right];
                right++;
            }
            if (total == M) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}