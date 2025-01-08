import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int[] used = new int[max + 1];

        int right = 0;
        int left = 0;
        long cnt = 0;

        while (right < N) {
            if(used[arr[right]] == 0) {
                used[arr[right]] = 1;
                right++;
                cnt+= right - left;
            }
            else if (used[arr[right]] == 1 ) {
                used[arr[left]] = 0;
                left++;
            }
        }
        System.out.println(cnt);
    }
}