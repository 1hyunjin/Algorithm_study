import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        int[] nums = new int[x];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (x - arr[i] > 0) {
                nums[arr[i]] = 1;
                int diff = x - arr[i];

                if (diff != arr[i] && nums[diff] == 1) {
                    cnt++;
                } 
            }
        }
        System.out.println(cnt);
    }
}