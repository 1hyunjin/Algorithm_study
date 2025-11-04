import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int gcd = gcd(N, M); // 최대공약수
            int lcm = (N*M)/gcd; // 최소공배수

            sb.append(lcm).append(" ").append(gcd).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static int gcd(int a, int b) {
        if (b ==0) {
            return a;
        }
        return gcd(b, a % b);
    }
}