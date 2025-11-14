import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] incline = new int[N];
        int[] decline = new int[N];
        Arrays.fill(incline, 1);
        Arrays.fill(decline, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    incline[i] = Math.max(incline[i], incline[j] + 1);
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    decline[i] = Math.max(decline[i], decline[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, incline[i] + decline[i] - 1);
        }
        System.out.println(max);
    }
}