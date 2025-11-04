import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 최대공약수
        int gcd = gcd(N, M);
        int lcm = N*M/gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int gcd(int a, int b) {
        if (b ==0) {
            return a;
        }
        return gcd(b, a % b);
    }
}