import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int[] dup = new int[max+1];

        int left = 0;
        int right = 0;
        int result = 0;
        int len = 0;

        while (right < N) {

            if (dup[arr[right]] < K) {
                dup[arr[right]]++;
                right++;
                len++;
            } else {
                dup[arr[left]]--;
                left++;
                len--;
            }

            result = Math.max(result, len);
        }

        System.out.println(result);
    }
}