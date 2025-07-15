import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[j] += Integer.parseInt(st.nextToken());
            }
        }
        int A = Integer.parseInt(br.readLine());

        int[] sumArr = new int[M+1];

        for (int i = 1; i <= M; i++) {
            sumArr[i] += sumArr[i-1] + arr[i];
        }
        int sum = sumArr[A]-sumArr[0];
        int max = sum;

        for (int i = A + 1; i <= M; i++) {
            max = Math.max(max, sumArr[i] - sumArr[i-A]);
        }
        System.out.println(max);
    }
}