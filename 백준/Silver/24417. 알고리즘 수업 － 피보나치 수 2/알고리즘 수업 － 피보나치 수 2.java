import java.io.*;
import java.util.*;

public class Main {
    static int fibCnt, dpCnt;
    static int[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 1000000007;
        fibCnt = 0;
        dpCnt = 0;
        f = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        sb.append(fibonacci(n)).append(" ");
        sb.append((n - 2) % max);
        System.out.println(sb);
    }

    public static int fibonacci(int n) {
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2])%1000000007;
        }
        return f[n];
    }
}