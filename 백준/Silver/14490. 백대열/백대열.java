import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] c = s.split(":");
        int a = 0;
        int b = 0;

        a = Integer.parseInt(c[0]);
        b = Integer.parseInt(c[1]);
        int n = 0;
        if (a > b) {
            n = gcd(a, b);
        } else {
            n = gcd(b, a);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(a / n).append(":").append(b / n);
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}