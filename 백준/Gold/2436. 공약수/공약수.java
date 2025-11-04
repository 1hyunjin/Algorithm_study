import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int G = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int N = L/G;
        long sum = Long.MAX_VALUE;
        long x = 0;
        long y = 0;
        for(int i = 1; i <= N; i++){
            if (N % i == 0) {
                int a = i;
                int b= N/i;
                if (gcd(a, b) == 1) {
                    if (a + b < sum) {
                        sum = a+b;
                        x = (long)a*G;
                        y = (long)b*G;
                    }
                }
            }
        }
        System.out.println(x + " " + y);

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}