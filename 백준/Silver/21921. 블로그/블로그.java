import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }
//        System.out.println(Arrays.toString(arr));

        int max = 0;
        int cnt = 0;

        for (int i = X; i <= N; i++) {
            if (max < arr[i] - arr[i - X]) {
                max = Math.max(max, arr[i] - arr[i - X]);
                cnt = 1;
            } else if (max == arr[i] - arr[i - X]) {
                cnt++;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
