import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[3*N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3 * N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int result = arr[3*N-N-1] - arr[N];
        System.out.println(result);
    }
}