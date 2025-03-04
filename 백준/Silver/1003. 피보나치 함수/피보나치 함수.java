import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static long[] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        fibo = new long[41];

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i < 41; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TC; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append("1 0\n");
                continue;
            }
            sb.append(fibo[n-1] + " " + fibo[n] + "\n");
        }
        System.out.println(sb);
    }
}