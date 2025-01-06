import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        while (end < N) {
            int diff = arr[end] - arr[start];

            if (diff >= M) {
                min = Math.min(min, diff);
                start++;
            }
            if (diff == M) {
                break;
            }
            if (diff <= M) {
                end++;
            }
        }
        System.out.println(min);
    }
}