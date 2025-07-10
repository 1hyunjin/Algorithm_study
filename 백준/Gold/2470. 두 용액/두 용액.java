import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        int result = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;

        while (true) {
            if (left >= right) {
                break;
            }
            int diff = arr[left] + arr[right];
            if (result > Math.abs(diff)) {
                result = Math.abs(diff);
                a = arr[left];
                b = arr[right];
                if (diff == 0) {
                    break;
                }
            }
            if (diff < 0) {
                left++;
            } else if (diff > 0) {
                right--;
            }
        }
        System.out.println(a + " " + b);
    }
}