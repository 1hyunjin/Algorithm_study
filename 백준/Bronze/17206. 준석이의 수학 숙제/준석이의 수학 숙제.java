import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[] arr = new long[80001];
        for (int i = 1; i <= 80000; i++) {
            arr[i] += arr[i-1];
            if (i % 3 == 0 || i%7 == 0) {
                arr[i] +=i;
            }
        }
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(arr[n]).append("\n");
        }
        System.out.println(sb);
    }
}