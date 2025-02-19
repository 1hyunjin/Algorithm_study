import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);
        int[] sum = new int[N];
        sum[0] = time[0];
        int result = sum[0];

        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + time[i];
            result += sum[i];
        }
        System.out.println(result);
    }
}