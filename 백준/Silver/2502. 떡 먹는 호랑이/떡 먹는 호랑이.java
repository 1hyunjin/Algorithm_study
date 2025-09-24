import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] fib = new int[31];
        fib[1] = 1;
        fib[2] = 1;

        for (int i = 3; i <= 30; i++) {
            fib[i] = fib[i-2] + fib[i-1];
        }

        int A = fib[D-2];
        int B = fib[D-1];

        for (int i = 1; i <= K; i++) {
            if ((K - (A * i)) % B == 0) {
                System.out.println(i);
                System.out.println((K - (A * i)) / B);
                break;
            }
        }
    }
}