import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        long sum = 0;
        long n;
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            n = Integer.parseInt(st.nextToken());
            arr[i] = n+arr[i-1];
            sum+=arr[i-1]*n;
        }
        System.out.println(sum);
    }
}