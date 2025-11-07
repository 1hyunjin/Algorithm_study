import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int sum = 0;
        int min = N;
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sum+=i;
                min = Math.min(min, i);
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        }
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}