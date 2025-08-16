import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                sum-=arr[i];
            }
            else {
                sum+=arr[i];
            }
        }
        int[] ans = new int[N+1];
        ans[1] = sum/2;
        for (int i = 2; i <= N; i++) {
            ans[i] = arr[i-1] - ans[i-1];
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(ans[i]);
        }
    }
}