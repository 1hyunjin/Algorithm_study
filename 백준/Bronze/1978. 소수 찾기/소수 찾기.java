import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        boolean[] isPrime = new boolean[max+1];
        for (int i = 0; i <= max; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (isPrime[arr[i]]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}