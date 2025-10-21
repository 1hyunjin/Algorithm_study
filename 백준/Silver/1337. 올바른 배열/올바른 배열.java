import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = 0;
        int size = 5;
        int result = 4;

        while (end < N) {
            if (arr[end] - arr[start] < size) {
                end++;
                result = Math.min(result, size - (end - start));
            }
            else{
                start++;
            }
        }
        System.out.println(result);
    }
}