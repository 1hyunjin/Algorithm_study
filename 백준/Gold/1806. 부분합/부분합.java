import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;

        int min = Integer.MAX_VALUE;
        int tot = 0;

        while (left <= right && right <= N) {
            // S 보다 작으면 right 이동
            if (tot < S) {
                tot += arr[right];
                right++;
            }
            // S랑 같거나 크다면 길이 최소 구하고 left 이동
            else if (tot >= S) {
                min = Math.min(min, right - left);
                tot -= arr[left];
                left++;
            }
        }
        // 합을 찾지 못한다면
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(min);
        }
    }
}