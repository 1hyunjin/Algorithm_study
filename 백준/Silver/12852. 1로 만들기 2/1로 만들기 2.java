import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] prev = new int[N+1];

        arr[1] = 0;

        for (int i = 2; i <= N; i++) {

            arr[i] = arr[i-1] + 1;
            prev[i] = i-1;

            if (i % 2 == 0 && arr[i] > arr[i/2] + 1) {
                arr[i] = arr[i/2] + 1;
                prev[i] =i/2;
            }
            if (i % 3 == 0 && arr[i] > arr[i/3] + 1) {
                arr[i] = arr[i/3] + 1;
                prev[i] = i/3;
            }
        }
        System.out.println(arr[N]);

        StringBuilder sb = new StringBuilder();
        int cur = N;
        sb.append(cur).append(" ");

        while (true) {
            if (cur == 1) {
                break;
            }
            sb.append(prev[cur]).append(" ");
            cur = prev[cur];
        }
        System.out.println(sb);
    }
}