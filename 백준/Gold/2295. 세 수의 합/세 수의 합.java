import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int idx = 0;
        int[] two = new int[N * (N + 1) / 2];

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                two[idx++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(two);

        int max = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if (Arrays.binarySearch(two, target) > -1) {
                    max = Math.max(max, arr[i]);
                }
            }
        }
        System.out.println(max);
    }
}