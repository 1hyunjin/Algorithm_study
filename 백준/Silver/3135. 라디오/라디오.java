import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int min = Math.abs(A-B);
        int idx = -1;
        for (int i = 0; i < N; i++) {
            int tmp = Math.abs(arr[i] - B);
            if (tmp < min) {
                min = tmp;
                idx = i;
            }
        }
        if (idx != -1) {
            System.out.println(1+Math.abs(arr[idx]-B));
        }
        else{
            System.out.println(Math.abs(A-B));
        }
    }
}