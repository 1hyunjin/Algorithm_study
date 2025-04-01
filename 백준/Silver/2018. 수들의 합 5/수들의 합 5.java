import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] + i;
        }

        int left = 0;
        int right = 1;
        int cnt = 0;
        while (left < N+1 && right < N+1) {

            if (arr[right] - arr[left] < N) {
                right++;
            }
            if (arr[right] - arr[left] > N) {
                left++;
            }
            if (arr[right] - arr[left] == N) {
                cnt++;
                right++;
                left++;
            }
        }
        System.out.println(cnt);
    }
}
